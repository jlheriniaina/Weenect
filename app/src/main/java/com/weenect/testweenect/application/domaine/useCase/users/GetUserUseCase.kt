package com.weenect.testweenect.application.domaine.useCase.users

import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.domaine.repositories.UserRepository
import com.weenect.testweenect.application.domaine.useCase.base.BaseUseCase
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) : BaseUseCase<String, User> {

    /**
     * Exécute le cas d'utilisation pour récupérer un utilisateur en fonction de son identifiant unique.
     *
     * @param input
     * @return L'utilisateur correspondant à l'identifiant unique spécifié.
     */
    override suspend fun execute(input: String): User {
        return userRepository.getUser(uuid = input)
    }
}