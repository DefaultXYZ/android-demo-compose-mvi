package com.defaultxyz.store.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.defaultxyz.store.db.dao.UserDao
import com.defaultxyz.store.db.model.UserEntity

@Database(
    entities = [
        UserEntity::class,
    ],
    version = 1
)
internal abstract class DemoDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        private const val DB_NAME = "db_demo"

        fun createDatabase(context: Context): DemoDatabase =
            Room.databaseBuilder(context, DemoDatabase::class.java, DB_NAME)
                .build()
    }
}
