package com.example.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import java.io.Closeable
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

/** [CoroutineScope] имплементит [Closeable] который отменяет корутину при закрытии. */
class CloseableCoroutineScope @Inject constructor(
    @MainImmediateCoroutineContext context: CoroutineContext
) : Closeable, CoroutineScope {

    override val coroutineContext: CoroutineContext = context

    override fun close() = coroutineContext.cancel()
}