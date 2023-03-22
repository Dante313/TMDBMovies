package com.example.network

import com.example.errors.ErrorEntity
import com.example.errors.ErrorHandler
import com.example.models.Either
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import kotlin.coroutines.cancellation.CancellationException

suspend fun <T : Any> safeApiCall(
    errorHandler: ErrorHandler,
    block: suspend () -> retrofit2.Response<T>
): Either<T> = try {
    val response = block()
    if (response.isSuccessful) {
        val body = response.body()
        if (body != null) {
            Either.Success(body)
        } else {
            Either.Failure<Any>(errorHandler.getError(IOException("Empty body")))
        }
    } else {
        Either.Failure<Any>(
            errorHandler.getError(
                IOException(
                    "Failed to read response, error code [${response.code()}]"
                )
            )
        )
    }
} catch (ioException: IOException) {
    Either.Failure<Any>(ErrorEntity.Network())
} catch (exception: Exception) {
    Either.Failure<Any>(errorHandler.getError(exception))
}
