package com.weenect.testweenect.framework.data.remote.service

import com.weenect.testweenect.framework.data.remote.api.RemoteApi
import com.weenect.testweenect.framework.data.remote.models.request.ParamBuilderQueryRequest
import com.weenect.testweenect.framework.data.remote.models.response.ApiResponse
import com.weenect.testweenect.framework.data.remote.models.response.UserResponse
import com.weenect.testweenect.framework.di.qualifier.Api
import java.lang.Exception
import javax.inject.Inject

class RemoteApiServiceImpl @Inject constructor(
    @Api
    private val remoteApi: RemoteApi
) : RemoteApiService {

    private val apiResponse  = ApiResponse()
    override suspend fun getUser(data: ParamBuilderQueryRequest): UserResponse {
        return try {
              val call = remoteApi.getData(params = data.build())
              apiResponse.execute(call, UserResponse::class.java)
        }catch (ex : Exception){
             UserResponse()
        }
    }


}