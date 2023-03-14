package com.example.mvi

import androidx.lifecycle.ViewModel
import com.example.coroutines.CloseableCoroutineScope
import kotlinx.coroutines.flow.StateFlow

/**
 * Базовый класс для всех [ViewModel] которые следуют паттерну MVI.
 *
 * @param S - [State] который управляется этой [ViewModel]
 * @param A - [Action] который выполняет этот [ViewModel]
 * @param closeableScope - [CloseableCoroutineScope] на котором будут выполняться корутины
 * @param reducer - [Reducer] который генерирует новое состояние из [State] и [Action]
 * @param middlewares - список из [Middleware] для выполнения [Action]
 * @param initialState - [State] по умолчанию
 */
abstract class MviViewModel<S : State, A : Action>(
    closeableScope: CloseableCoroutineScope,
    reducer: Reducer<S, A>,
    middlewares: List<Middleware<S, A>> = emptyList(),
    initialState: S
) : ViewModel(closeableScope) {

    private val stateReducer: StateReducerFlow<S, A> = stateReducerFlow(
        initialState = initialState,
        scope = closeableScope,
        reducer = reducer,
        middlewares = middlewares
    )

    /** [State] обработанный этим [MviViewModel] как [StateFlow] */
    val state: StateFlow<S> = stateReducer

    init {
        middlewares.forEach { middleware ->
            middleware.setup(
                scope = closeableScope,
                dispatcher = stateReducer
            )
        }
    }

    protected fun handleAction(action: A) = stateReducer.dispatch(action)
}