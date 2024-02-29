package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("large")
    var large : String? = null,
    @SerializedName("medium")
    var medium : String? = null,
    @SerializedName("thumbnail")
    var thumbnail : String? = null
)
