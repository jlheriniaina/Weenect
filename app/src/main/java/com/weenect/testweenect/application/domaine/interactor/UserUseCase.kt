package com.weenect.testweenect.application.domaine.interactor

import com.weenect.testweenect.application.domaine.entities.User
import kotlinx.coroutines.flow.Flow

interface UserUseCase {

    suspend fun getAllUser(page : Int) : Flow<List<User>>

}