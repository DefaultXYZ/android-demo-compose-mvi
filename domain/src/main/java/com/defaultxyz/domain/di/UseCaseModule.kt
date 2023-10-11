package com.defaultxyz.domain.di

import com.defaultxyz.domain.login.GetUserLoginUseCase
import com.defaultxyz.domain.login.GetUserLoginUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    internal abstract fun bindGetUserLoginUseCase(getUserLoginUseCaseImpl: GetUserLoginUseCaseImpl): GetUserLoginUseCase
}
