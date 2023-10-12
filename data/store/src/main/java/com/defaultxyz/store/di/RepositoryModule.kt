package com.defaultxyz.store.di

import com.defaultxyz.store.repository.UserRepository
import com.defaultxyz.store.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    fun userRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}
