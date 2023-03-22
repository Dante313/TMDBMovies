package com.example.errors

interface ErrorHandler {

    fun getError(throwable: Throwable): ErrorEntity
}