package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type

class ApiResponse {

    suspend fun <T : Any> execute(
        response : Response<ResponseBody>,
        typeOfT: Type
    ): T = withContext(Dispatchers.IO) {
        try {
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Gson().fromJson<T>(body.charStream(), typeOfT)
            } else {
                throw IOException("Not found")
            }
        } catch (e: Exception) {
            e
            throw e
        }
    }
}