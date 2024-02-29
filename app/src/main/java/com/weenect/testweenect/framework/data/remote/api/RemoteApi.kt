package com.weenect.testweenect.framework.data.remote.api

import com.weenect.testweenect.framework.data.remote.models.ApiEndpoint
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RemoteApi {

    @GET(ApiEndpoint.USERS)
    @JvmSuppressWildcards
    suspend fun getData(@QueryMap params : Map<String, Any>) : Response<ResponseBody>
}