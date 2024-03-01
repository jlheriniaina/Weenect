package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName

/**
 *
 *
 * @property uuid
 * @property username
 * @property password
 * @property salt
 * @property md5
 * @property sha1
 * @property sha256
 */
data class UserLoginInfo(
    @SerializedName("uuid")
    var uuid : String? = null,
    @SerializedName("username")
    var username : String? = null,
    @SerializedName("password")
    var password : String? = null,
    @SerializedName("salt")
    var salt : String? = null,
    @SerializedName("md5")
    var md5 : String? = null,
    @SerializedName("sha1")
    var sha1 : String? = null,
    @SerializedName("sha256")
    var sha256 : String? = null
)