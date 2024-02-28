package com.weenect.testweenect.data.remote.models.response

import com.google.gson.annotations.SerializedName
import com.weenect.testweenect.domaine.entities.User

data class UserResponse(
    @SerializedName("results" )
    var results : List<UserResult> = listOf()
)