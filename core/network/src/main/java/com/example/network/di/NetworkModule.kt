package com.example.network.di

import com.example.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import logcat.LogPriority
import logcat.logcat
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

private const val OkHttpTag = "OkHttp"
private const val MediaType = "application/json"

private const val CONNECT_TIMEOUT_SECONDS = 15L
private const val READ_TIMEOUT_SECONDS = 30L

private const val HEADER_KEY = "X-RapidAPI-Key"
private const val HEADER_HOST = "X-RapidAPI-Host"

private const val HOST = "moviesdatabase.p.rapidapi.com"
private const val URL = "https://moviesdatabase.p.rapidapi.com/"

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    private val json = Json { ignoreUnknownKeys = true }

    @Provides
    @Singleton
    @AuthorizationInterceptor
    fun provideAuthorizationInterceptor(): Interceptor = Interceptor { chain ->
        val original: Request = chain.request()
        val request: Request = original.newBuilder()
            .header(HEADER_KEY, BuildConfig.API_KEY)
            .header(HEADER_HOST, HOST)
            .method(original.method, original.body)
            .build()

        chain.proceed(request)
    }

    @Provides
    @Singleton
    @LoggingInterceptor
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor { message ->
        logcat(tag = OkHttpTag, priority = LogPriority.INFO) { message }
    }.apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @AuthorizationInterceptor authInterceptor: Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(CONNECT_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(READ_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(json.asConverterFactory(MediaType.toMediaType()))
        .client(okHttpClient)
        .build()
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class LoggingInterceptor

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class AuthorizationInterceptor