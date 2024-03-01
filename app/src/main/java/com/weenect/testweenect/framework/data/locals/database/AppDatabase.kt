package com.weenect.testweenect.framework.data.locals.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.weenect.testweenect.framework.data.locals.dao.UserDao
import com.weenect.testweenect.application.domaine.entities.User

@Database(entities = [User::class], version = 1 ,exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Renvoie une instance de UserDao.
     *
     * @return
     */
    abstract fun userDao() : UserDao
}