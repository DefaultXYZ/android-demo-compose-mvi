package com.defaultxyz.store.repository

import com.defaultxyz.model.user.User

interface UserRepository {
    suspend fun getListOfNames(): List<Pair<String, String>>
    suspend fun getCurrentUser(): User?
    suspend fun createNew(user: User)
    suspend fun removeCurrent()
}
