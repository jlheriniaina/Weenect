package com.weenect.testweenect.application.domaine.useCase.users

import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.domaine.repositories.UserRepository
import com.weenect.testweenect.application.domaine.useCase.base.BaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) : BaseUseCase<Int, Flow<List<User>>> {

    /**
     * Exécute le cas d'utilisation pour récupérer une liste d'utilisateurs à partir de la page spécifiée.
     *
     * @param input
     * @return Un [Flow] émettant la liste d'utilisateurs récupérée.
     */
    override suspend fun execute(input: Int): Flow<List<User>> {
        return flow {
            val users = userRepository.getUsers(page = input)
            emit(users)
        }.flowOn(Dispatchers.IO)
    }
}