package com.weenect.testweenect.data.remote.service

import com.weenect.testweenect.data.remote.api.RemoteApi
import com.weenect.testweenect.di.qualifier.Api
import javax.inject.Inject

class RemoteApiServiceImpl @Inject constructor(
    @Api
    private val remoteApi: RemoteApi
) : RemoteApiService {



    override suspend fun getUser() {

    }

}