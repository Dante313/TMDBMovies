package com.example.models

import com.example.errors.ErrorEntity

sealed interface Either<out T> {
    class Success<T>(val value: T) : Either<T>
    class Failure<U>(val error: ErrorEntity) : Either<Nothing>
}

inline fun <R, T> Either<T>.fold(
    onSuccess: (value: T) -> R,
    onFailure: (error: ErrorEntity) -> R
): R = when(this) {
    is Either.Success -> onSuccess(value)
    is Either.Failure<*> -> onFailure(error)
}

val <T> Either<T>.isSuccess: Boolean
    get() = this is Either.Success

val <T> Either<T>.isFailure: Boolean
    get() = this is Either.Failure<*>

fun <T> Either<T>.valueOrNull(): T? = (this as? Either.Success)?.value