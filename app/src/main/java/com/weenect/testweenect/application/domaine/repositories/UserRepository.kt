package com.weenect.testweenect.application.domaine.repositories

import com.weenect.testweenect.application.domaine.entities.User

interface UserRepository {
    suspend fun getUsers(page : Int) : List<User>
}