package com.weenect.testweenect.framework.data.locals.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.weenect.testweenect.application.domaine.entities.User

@Dao
interface UserDao {
    /**
     * Renvoi liste utilisateur enregistre
     *
     * @return
     */
    @Query("SELECT * FROM user")
    suspend fun findAll() : List<User>

    /**
     * Renvoi une utilisateur
     *
     * @param userId
     * @return
     */
    @Query("SELECT * FROM user WHERE uuid=:userId")
    suspend fun find(userId : String) : User

    /**
     * Insertion utilisateur
     *
     * @param user
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    /**
     * Ajouter liste utilisateur returne par l'API
     *
     * @param users
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users : List<User>)


}