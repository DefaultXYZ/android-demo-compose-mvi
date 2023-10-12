package com.defaultxyz.domain.di

import com.defaultxyz.domain.login.GetCurrentUserUseCase
import com.defaultxyz.domain.login.GetCurrentUserUseCaseImpl
import com.defaultxyz.domain.login.GetRandomUserUseCase
import com.defaultxyz.domain.login.GetRandomUserUseCaseImpl
import com.defaultxyz.domain.login.IsUserExistsUseCase
import com.defaultxyz.domain.login.IsUserExistsUseCaseImpl
import com.defaultxyz.domain.login.SaveUserUseCase
import com.defaultxyz.domain.login.SaveUserUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface UseCaseModule {

    @Binds
    fun getUserLoginUseCase(getUserLoginUseCaseImpl: IsUserExistsUseCaseImpl): IsUserExistsUseCase

    @Binds
    fun getRandomUserUseCase(getRandomUserUseCaseImpl: GetRandomUserUseCaseImpl): GetRandomUserUseCase

    @Binds
    fun saveUserUseCase(saveUserUseCaseImpl: SaveUserUseCaseImpl): SaveUserUseCase

    @Binds
    fun getCurrentUserUseCase(getCurrentUserUseCaseImpl: GetCurrentUserUseCaseImpl): GetCurrentUserUseCase
}
