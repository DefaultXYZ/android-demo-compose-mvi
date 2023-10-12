package com.defaultxyz.domain.login

import com.defaultxyz.store.repository.UserRepository
import javax.inject.Inject

internal class GetRandomUserUseCaseImpl @Inject constructor(
    private val userRepository: UserRepository
): GetRandomUserUseCase {
    override suspend fun invoke(): Pair<String, String> = userRepository.getListOfNames().random()
}
