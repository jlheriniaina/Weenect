package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName

data class Coordinate(
    @SerializedName("latitude")
    var latitude  : String? = null,
    @SerializedName("longitude")
    var longitude : String? = null
)
