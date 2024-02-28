package com.weenect.testweenect.data.remote.models.response

import com.google.gson.annotations.SerializedName

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
    var postcode : Int?= null,
    @SerializedName("coordinates" )
    var coordinate : Coordinate? = Coordinate(),
    @SerializedName("timezone")
    var timezone : Timezone? = Timezone()
)
