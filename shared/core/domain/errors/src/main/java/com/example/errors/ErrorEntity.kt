package com.example.errors

sealed class ErrorEntity {

    data class Network(val msg: String? = null) : ErrorEntity()

    object NotFound : ErrorEntity()

    object AccessDenied : ErrorEntity()

    object ServiceUnavailable : ErrorEntity()

    object Unknown : ErrorEntity()
}