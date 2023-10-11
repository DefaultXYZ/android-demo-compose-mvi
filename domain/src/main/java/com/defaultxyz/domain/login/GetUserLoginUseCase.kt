package com.defaultxyz.domain.login

interface GetUserLoginUseCase {
    suspend fun get(): Boolean
}
