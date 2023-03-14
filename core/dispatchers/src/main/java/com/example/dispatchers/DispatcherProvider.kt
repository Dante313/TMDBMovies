package com.example.dispatchers

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext

/** Предоставляет [CoroutineDispatcher]ы для использования в приложении. */
interface DispatcherProvider {

    /** [CoroutineDispatcher] для CPU связанных операций. */
    val default: CoroutineContext

    /** [CoroutineDispatcher] для IO задач. */
    val io: CoroutineContext

    /** [CoroutineDispatcher] для задач на UI потоке. */
    val main: CoroutineContext

    /** [CoroutineDispatcher] для CPU связанных задач с немедленной отправкой. */
    val mainImmediate: CoroutineContext

    /** [CoroutineDispatcher] для задач не закрепленных за конкретным потоком. */
    val unconfined: CoroutineContext
}