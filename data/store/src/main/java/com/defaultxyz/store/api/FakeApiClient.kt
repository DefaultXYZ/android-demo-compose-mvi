package com.defaultxyz.store.api

import javax.inject.Inject

internal class FakeApiClient @Inject constructor(): ApiClient {
    private val firstNames = listOf("Wonderful", "Fairy", "Dangerous", "Funny", "Humorous", "Scary")
    private val lastNames = listOf("Rabbit", "Cat", "Wolf", "Dog", "Squirrel", "Parrot")

    override suspend fun getListOfUserNames(): List<Pair<String, String>> =
        firstNames.shuffled().zip(lastNames.shuffled())
}
