package com.weenect.testweenect.application.domaine.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.weenect.testweenect.framework.data.remote.models.response.Location
import com.weenect.testweenect.framework.data.remote.models.response.Picture
import com.weenect.testweenect.framework.data.remote.models.response.UserIdInfo
import com.weenect.testweenect.framework.data.remote.models.response.UserInfo

/**
 * Table user
 *
 * @property uuid
 * @property title
 * @property name
 * @property firstname
 * @property avatarProfil
 * @property gender
 * @property email
 * @property phone
 * @property cell
 * @property age
 * @property address
 * @property lat
 * @property lng
 */
@Entity(tableName = "user")
data class User(
    @PrimaryKey
    var uuid : String = "",
    var title : String = "",
    var name : String,
    var firstname : String,
    var avatarProfil : String,
    var gender : String?= null,
    var email : String?= null,
    var phone : String?= null,
    var cell : String? = null,
    var age : Int,
    var address : String,
    var lat : Double = 0.0,
    var lng : Double = 0.0

)
