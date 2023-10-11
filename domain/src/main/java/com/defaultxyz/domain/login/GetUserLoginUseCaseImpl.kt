package com.defaultxyz.domain.login

import javax.inject.Inject

internal class GetUserLoginUseCaseImpl @Inject constructor() : GetUserLoginUseCase {
    override suspend fun get(): Boolean {
        return true
    }
}
