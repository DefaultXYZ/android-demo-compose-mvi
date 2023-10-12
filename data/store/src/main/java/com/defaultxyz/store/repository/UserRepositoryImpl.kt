package com.defaultxyz.store.repository

import com.defaultxyz.model.user.User
import com.defaultxyz.store.api.ApiClient
import com.defaultxyz.store.db.dao.UserDao
import com.defaultxyz.store.db.model.UserEntity
import com.defaultxyz.utils.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class UserRepositoryImpl @Inject constructor(
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
    private val apiClient: ApiClient,
    private val userDao: UserDao
) : UserRepository {
    override suspend fun getListOfNames(): List<Pair<String, String>> =
        withContext(ioDispatcher) {
            apiClient.getListOfUserNames()
        }

    override suspend fun getCurrentUser(): User? =
        withContext(ioDispatcher) {
            userDao.runCatching {
                get().let { User(id = it.id, firstName = it.firstName, lastName = it.lastName, counter = it.counter) }
            }.getOrNull()
        }

    override suspend fun createNew(user: User) {
        withContext(ioDispatcher) {
            userDao.insert(UserEntity(firstName = user.firstName, lastName = user.lastName, counter = user.counter))
        }
    }

    override suspend fun removeCurrent() {
        withContext(ioDispatcher) {
            userDao.clear()
        }
    }
}
