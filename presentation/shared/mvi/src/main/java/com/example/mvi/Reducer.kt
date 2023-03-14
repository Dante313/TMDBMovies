package com.example.mvi

/** Используется для синхронных обновлений состояния [State]. */
interface Reducer<S : State, A : Action> {
    /**
     * Создаёт новый экземпляр [State] основываясь на [Action].
     *
     * @param state - текущий [State]
     * @param action - [Action] который преобразует текущий [State] в
     * @return новый [State]
     */
    fun reduce(state: S, action: A): S
}