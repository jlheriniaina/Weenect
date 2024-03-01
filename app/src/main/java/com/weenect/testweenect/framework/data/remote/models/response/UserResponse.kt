package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName
import com.weenect.testweenect.application.domaine.entities.User

/**
 * DTO Représente la réponse de l'API contenant une liste d'utilisateurs.
 *
 * @property results
 */
data class UserResponse(
    @SerializedName("results" )
    var results : List<UserResult> = listOf()
)