package com.defaultxyz.store.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.defaultxyz.store.db.model.UserEntity

@Dao
internal interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userEntity: UserEntity)

    @Query("SELECT * FROM UserEntity WHERE id = 1")
    suspend fun get(): UserEntity

    @Query("DELETE FROM UserEntity")
    suspend fun clear()
}
