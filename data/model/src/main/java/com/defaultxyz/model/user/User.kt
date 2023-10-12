package com.defaultxyz.model.user

data class User(
    val firstName: String,
    val lastName: String,
    val id: Int? = null,
    val counter: Int = 0
)
