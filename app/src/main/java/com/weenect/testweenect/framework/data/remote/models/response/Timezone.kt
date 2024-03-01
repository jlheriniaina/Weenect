package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName

/**
 * DTO Time zone de  l'utilisateur
 *
 * @property offset
 * @property description
 */
data class Timezone(
    @SerializedName("offset")
    var offset : String? = null,
    @SerializedName("description")
    var description : String? = null
)
