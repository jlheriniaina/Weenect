package com.weenect.testweenect.framework.data.remote.service

import com.weenect.testweenect.framework.data.remote.models.request.ParamBuilderQueryRequest
import com.weenect.testweenect.framework.data.remote.models.response.UserResponse

/**
 * Interface décrivant un service pour les appels d'API distantes.
 */
interface RemoteApiService {

    /**
     * Récupère les utilisateurs en fonction des paramètres spécifiés.
     *
     * @param data // Les paramètres de la requête.
     * @return // La réponse contenant les utilisateurs.
     */
    suspend fun getUser(data : ParamBuilderQueryRequest) : UserResponse
}