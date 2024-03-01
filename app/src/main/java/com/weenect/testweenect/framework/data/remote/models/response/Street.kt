package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName

/**
 * DTO Adresse
 *
 * @property number
 * @property name
 */
data class Street(
    @SerializedName("number")
    var number : Int?= null,
    @SerializedName("name")
    var name : String? =null
)
