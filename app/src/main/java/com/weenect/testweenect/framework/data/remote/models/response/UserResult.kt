package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName

/**
 *
 *
 * @property gender
 * @property userInfo
 * @property location
 * @property email
 * @property phone
 * @property cell
 * @property id
 * @property picture
 * @property nat
 * @property userLogin
 */
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
    var nat  : String?= null,
    @SerializedName("login")
    var userLogin : UserLoginInfo? = UserLoginInfo()
)