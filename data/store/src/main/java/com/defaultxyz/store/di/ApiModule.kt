package com.defaultxyz.store.di

import com.defaultxyz.store.api.ApiClient
import com.defaultxyz.store.api.FakeApiClient
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {

    @Binds
    internal abstract fun apiClient(fakeApiClient: FakeApiClient): ApiClient
}
