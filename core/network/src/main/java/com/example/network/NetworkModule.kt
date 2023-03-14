package com.example.network

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

private const val ConnectTimeoutSeconds = 15L
private const val ReadTimeoutSeconds = 30L

private const val HeaderKey = "X-RapidAPI-Key"
private const val HeaderHost = "X-RapidAPI-Host"

// TODO: move to buildconfig
private const val key = "0b348d7b70msh67561ff98ccee00p120090jsn9664847ea987"
private const val host = "moviesdatabase.p.rapidapi.com"
private const val url = "https://moviesdatabase.p.rapidapi.com/"

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
            .header(HeaderKey, key)
            .header(HeaderHost, host)
            .method(original.method, original.body)
            .build()

        chain.proceed(request)
    }

    @Provides
    @Singleton
    @LoggingInterceptor
    fun provideLoggingInterceptor(): Interceptor = HttpLoggingInterceptor { message ->
        logcat(LogPriority.INFO) { message }
    }.apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @AuthorizationInterceptor authInterceptor: Interceptor,
        @LoggingInterceptor loggingInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(ConnectTimeoutSeconds, TimeUnit.SECONDS)
        .readTimeout(ReadTimeoutSeconds, TimeUnit.SECONDS)
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(url)
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