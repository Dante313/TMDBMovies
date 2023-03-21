package com.example.data.di

import com.example.data.UpcomingApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Singleton
    @Provides
    fun providesUpcomingApi(retrofit: Retrofit) = retrofit.create(UpcomingApi::class.java)
}