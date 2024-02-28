package com.weenect.testweenect.data.remote.models.response

import com.google.gson.annotations.SerializedName

class UserResult(
    @SerializedName("gender")
    var gender : String?= null,
    @SerializedName("name")
    var userInfo  : UserInfo? = UserInfo(),
    @SerializedName("location")
    var location : Location? = Location(),
    @SerializedName("email")
    var email : String?= null,
    @SerializedName("phone"      )
    var phone : String?= null,
    @SerializedName("cell"       )
    var cell : String? = null,
    @SerializedName("id"         )
    var id : UserIdInfo? = UserIdInfo(),
    @SerializedName("picture" )
    var picture    : Picture?= Picture(),
    @SerializedName("nat")
    var nat  : String?= null
)