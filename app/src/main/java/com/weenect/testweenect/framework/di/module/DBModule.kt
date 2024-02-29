package com.weenect.testweenect.framework.di.module

import android.content.Context
import androidx.room.Room
import com.weenect.testweenect.framework.data.locals.dao.UserDao
import com.weenect.testweenect.framework.data.locals.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    private val DATABESE_NAME  = "weenect-db"
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, DATABESE_NAME)
            .fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase) : UserDao = appDatabase.userDao()
}