package com.defaultxyz.store.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Calendar

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 1,
    val firstName: String,
    val lastName: String,
    val counter: Int,
    val timestampMillis: Long = Calendar.getInstance().timeInMillis
)
