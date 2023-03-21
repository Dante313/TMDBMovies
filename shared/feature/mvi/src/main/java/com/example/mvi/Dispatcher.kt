package com.example.mvi

/** Отправляет [Action] на выполнение во фреймворке MVI. */
interface Dispatcher<A : Action> {
    /**
     * Отправляет [Action] на выполнение фреймворком MVI.
     *
     * @param action - [Action] который необходимо обработать
     */
    fun dispatch(action: A)
}