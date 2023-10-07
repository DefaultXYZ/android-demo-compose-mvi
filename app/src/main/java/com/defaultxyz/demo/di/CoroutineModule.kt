package com.defaultxyz.demo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class CoroutineModule {

    @Provides
    @IODispatcher
    fun ioCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @MainDispatcher
    fun mainCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
