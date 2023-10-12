package com.defaultxyz.store.api

interface ApiClient {
    suspend fun getListOfUserNames(): List<Pair<String, String>>
}
