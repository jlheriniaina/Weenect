package com.weenect.testweenect.framework.data.locals.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.weenect.testweenect.application.domaine.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun findAll() : List<User>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)
    @Insert
    suspend fun insertAll(users : List<User>)


}