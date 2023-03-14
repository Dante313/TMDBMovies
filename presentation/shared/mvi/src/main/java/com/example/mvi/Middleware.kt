package com.example.mvi

import kotlinx.coroutines.CoroutineScope

/** Обрабатывает асинхронно [Action] в MVI. */
abstract class Middleware<S : State, A : Action> {

    protected lateinit var dispatcher: Dispatcher<A>
    protected lateinit var scope: CoroutineScope

    /**
     * Обрабатывает [Action]. Этот метод должен быстро выполняться и запускать асинхронную операцию
     *
     * @param state - текущий [State]
     * @param action - [Action] на обработку
     */
    abstract fun process(state: S, action: A)

    protected fun dispatch(action: A) = dispatcher.dispatch(action)

    internal fun setup(
        scope: CoroutineScope,
        dispatcher: Dispatcher<A>
    ) {
        this.dispatcher = dispatcher
        this.scope = scope
    }
}