package com.weenect.testweenect.framework.data.remote.service

import com.weenect.testweenect.framework.data.remote.models.request.ParamBuilderQueryRequest
import com.weenect.testweenect.framework.data.remote.models.response.UserResponse

interface RemoteApiService {

    suspend fun getUser(data : ParamBuilderQueryRequest) : UserResponse
}