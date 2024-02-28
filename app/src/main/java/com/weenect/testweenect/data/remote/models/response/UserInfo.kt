package com.weenect.testweenect.data.remote.models.response

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("title" )
    var title : String? = null,
    @SerializedName("first" )
    var first : String? = null,
    @SerializedName("last"  )
    var last  : String? = null
)