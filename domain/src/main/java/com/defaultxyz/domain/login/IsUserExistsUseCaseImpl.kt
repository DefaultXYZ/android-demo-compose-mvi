package com.defaultxyz.domain.login

import com.defaultxyz.store.repository.UserRepository
import javax.inject.Inject

internal class IsUserExistsUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : IsUserExistsUseCase {
    override suspend fun invoke(): Boolean =
        userRepository.getCurrentUser() != null
}
