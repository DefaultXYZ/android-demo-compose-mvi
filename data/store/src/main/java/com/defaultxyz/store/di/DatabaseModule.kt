package com.defaultxyz.store.di

import android.content.Context
import androidx.room.RoomDatabase
import com.defaultxyz.store.db.DemoDatabase
import com.defaultxyz.store.db.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class DatabaseModule {

    @Provides
    @Singleton
    fun demoDatabase(@ApplicationContext context: Context): DemoDatabase = DemoDatabase.createDatabase(context)

    @Provides
    fun userDao(database: DemoDatabase): UserDao = database.userDao()
}
