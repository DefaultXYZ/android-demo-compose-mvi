package com.defaultxyz.domain.login

import com.defaultxyz.model.user.User
import com.defaultxyz.store.repository.UserRepository
import javax.inject.Inject

class SaveUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
) : SaveUserUseCase {
    override suspend fun invoke(p1: Pair<String, String>) {
        userRepository.createNew(User(firstName = p1.first, lastName = p1.second))
    }
}
