package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.annotations.SerializedName

/**
 * DTO Information sur l'adresse
 *
 * @property street
 * @property city
 * @property state
 * @property country
 * @property postcode
 * @property coordinate
 * @property timezone
 */
data class Location(
    @SerializedName("street")
    var street : Street? = Street(),
    @SerializedName("city")
    var city : String?= null,
    @SerializedName("state")
    var state : String?= null,
    @SerializedName("country")
    var country : String?= null,
    @SerializedName("postcode")
    var postcode : String?= null,
    @SerializedName("coordinates" )
    var coordinate : Coordinate? = Coordinate(),
    @SerializedName("timezone")
    var timezone : Timezone? = Timezone()
)
