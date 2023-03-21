package com.example.coroutines

import com.example.dispatchers.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
internal object CoroutineModule {
    @Provides
    @MainImmediateCoroutineContext
    fun provideCoroutineContext(
        dispatcherProvider: DispatcherProvider
    ): CoroutineContext = SupervisorJob() + dispatcherProvider.mainImmediate
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class MainImmediateCoroutineContext