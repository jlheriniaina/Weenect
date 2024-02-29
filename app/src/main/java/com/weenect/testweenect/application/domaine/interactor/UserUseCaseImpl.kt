package com.weenect.testweenect.application.domaine.interactor

import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.domaine.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserUseCaseImpl
@Inject
constructor(
    private val userRepository: UserRepository
) : UserUseCase {
    override suspend fun getAllUser(page: Int): Flow<List<User>> {
       return flow {
               val users = userRepository.getUsers(page)
               emit(users)
       }.flowOn(Dispatchers.IO)
    }
}