package com.example.network

import kotlin.coroutines.cancellation.CancellationException
import retrofit2.HttpException
import java.io.IOException

suspend fun <T : Any> safeApiCall(
    block: suspend () -> retrofit2.Response<T>
): Either<T> = try {
    val response = block()
    if (response.isSuccessful) {
        val body = response.body()
        if (body != null) {
            Either.Success(body)
        } else {
            Either.Failure(IOException("Empty body"))
        }
    } else {
        Either.Failure(IOException("Failed to read response, error code [${response.code()}]"))
    }
} catch (ex: CancellationException) {
    throw ex
} catch (ex: HttpException) {
    Either.Failure(ex)
} catch (ex: IOException) {
    Either.Failure(ex)
}