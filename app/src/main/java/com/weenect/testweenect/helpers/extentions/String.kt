package com.weenect.testweenect.helpers.extentions


fun String.appendParams(vararg params: Pair<String, Any?>): String {
    val builder = StringBuilder(this)
    params.forEach {
        it.second?.toString()?.let { arg ->
            builder.append("/$arg")
        }
    }
    return builder.toString()
}