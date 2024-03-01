package com.weenect.testweenect.application.domaine.repositories

import com.weenect.testweenect.application.domaine.entities.User

interface UserRepository {
    /**
     * Récupère une liste de utilisateurs à partir de la page spécifiée
     *
     * @param page //Le numéro de la page à récupérer.
     * @return Une liste d'utilisateurs.
     */
    suspend fun getUsers(page : Int) : List<User>

    /**
     * Récupère un utilisateur en fonction de son identifiant unique.
     *
     * @param uuid L'identifiant unique de l'utilisateur.
     * @return L'utilisateur correspondant à l'identifiant unique spécifié.
     */
    suspend fun getUser(uuid : String) : User
}