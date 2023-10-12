package com.defaultxyz.domain.login

import com.defaultxyz.model.user.User
import com.defaultxyz.store.repository.UserRepository
import javax.inject.Inject

internal class GetCurrentUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : GetCurrentUserUseCase {
    override suspend fun invoke(): User = requireNotNull(userRepository.getCurrentUser())
}
