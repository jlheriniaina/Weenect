package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName

data class UserIdInfo(
    @SerializedName("name"  )
    var name  : String? = null,
    @SerializedName("value" )
    var value : String? = null
)
