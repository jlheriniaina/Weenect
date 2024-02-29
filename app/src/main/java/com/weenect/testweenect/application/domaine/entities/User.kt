package com.weenect.testweenect.application.domaine.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.weenect.testweenect.framework.data.remote.models.response.Location
import com.weenect.testweenect.framework.data.remote.models.response.Picture
import com.weenect.testweenect.framework.data.remote.models.response.UserIdInfo
import com.weenect.testweenect.framework.data.remote.models.response.UserInfo

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,
    var name : String,
    var firstname : String,
    var avatarProfil : String,
    var gender : String?= null,
    var email : String?= null,
    var phone : String?= null,
    var cell : String? = null,
    var age : Int
)
