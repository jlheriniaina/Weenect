package com.weenect.testweenect.data.remote.api

import com.weenect.testweenect.data.remote.models.ApiEndpoint
import okhttp3.ResponseBody
import retrofit2.http.GET

interface RemoteApi {

    @GET(ApiEndpoint.USERS)
    suspend fun getData() : ResponseBody
}