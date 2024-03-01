package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName


/**
 * DTO Info personnelle d'utilisateur
 *
 * @property title
 * @property first
 * @property last
 */
data class UserInfo(
    @SerializedName("title" )
    var title : String? = null,
    @SerializedName("first" )
    var first : String? = null,
    @SerializedName("last"  )
    var last  : String? = null
)