package com.example.resourcemanagers.di

import com.example.resourcemanagers.lookup.StringLookup
import com.example.resourcemanagers.lookup.StringLookupImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
internal interface ResourcesModule {

    @Binds
    @Reusable
    fun bindsStringLookup(stringLookupImpl: StringLookupImpl): StringLookup
}