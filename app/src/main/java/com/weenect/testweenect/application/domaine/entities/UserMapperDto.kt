package com.weenect.testweenect.application.domaine.entities

import com.weenect.testweenect.framework.data.remote.models.response.UserResult


fun UserResult.mapFromDto() = User(
    uuid = this.userLogin?.uuid?: generateRandom(),
    title = this.userInfo?.title?: "",
    name = this.userInfo?.last ?: "",
    firstname = this.userInfo?.first?: "",
    avatarProfil = this.picture?.large?: "",
    gender = this.gender,
    email = this.email,
    phone = this.phone,
    cell = this.cell, age = 10,
    address = "${this.location?.street?.name ?: ""}, ${this.location?.city?: ""}, ${this.location?.postcode?: ""},${this.location?.country} ",
    lat = this.location?.coordinate?.latitude?.toDouble()?: 0.0,
    lng = this.location?.coordinate?.longitude?.toDouble()?: 0.0,
)

private fun generateRandom(): String {
    val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    return (1..100)
        .map { charset.random() }
        .joinToString("")
}