package com.example.data.di

import com.example.data.repositories.UpcomingRepositoryImpl
import com.example.domain.repositories.UpcomingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsUpcomingRepository(upcomingRepositoryImpl: UpcomingRepositoryImpl): UpcomingRepository
}