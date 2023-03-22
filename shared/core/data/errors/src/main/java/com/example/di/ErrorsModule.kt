package com.example.di

import com.example.errors.ErrorHandler
import com.example.errors.GeneralErrorHandlingImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface ErrorsModule {

    @Singleton
    @Binds
    fun bindsGeneralErrorHandlingImpl(generalErrorHandlingImpl: GeneralErrorHandlingImpl): ErrorHandler
}