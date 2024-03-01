package com.weenect.testweenect.helpers

import com.weenect.testweenect.helpers.extentions.appendParams

const val KEY_USER_ID = "userId"

sealed class Destination(protected val route: String, vararg params: String) {

    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}}") }
        builder.toString()
    }
    sealed class NoArgumentsDestination(route: String) : Destination(route) {
        operator fun invoke(): String = route
    }

    data object UserScreen : NoArgumentsDestination(NavigationConstant.USER_SCREEN)
    data object DetailsUserScreen : Destination(NavigationConstant.DETAILS, "userId"){

        operator fun invoke(userId : String) : String = route.appendParams(
            KEY_USER_ID to userId
        )
    }

}
