package com.weenect.testweenect.application.domaine.repositories

import android.util.Log
import com.google.gson.Gson
import com.weenect.testweenect.framework.data.locals.dao.UserDao
import com.weenect.testweenect.framework.data.remote.models.request.ParamBuilderQueryRequest
import com.weenect.testweenect.framework.data.remote.models.response.UserResult
import com.weenect.testweenect.framework.data.remote.service.RemoteApiService
import com.weenect.testweenect.application.domaine.entities.User
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class UserRepositoryImpl @Inject  constructor(
    private val remoteApiService: RemoteApiService,
    private val userDao: UserDao
) : UserRepository {


    override suspend fun getUsers(): List<User> {
       return coroutineScope {
           val data = remoteApiService.getUser(
                         data = ParamBuilderQueryRequest()
                               .addParams(
                                   "page" to 1,
                                   "results" to 10,
                                   "seed" to "weenect"
                               )
           )
           Log.d("TEST_APP", Gson().toJson(data))
           if (data.results.isNotEmpty()){
               val users = mapperUser(data.results)
               userDao.insertAll(users)
               return@coroutineScope users
           }else {
               userDao.findAll()
           }
           return@coroutineScope emptyList()
       }
    }
    private fun mapperUser(users : List<UserResult>) : List<User> {
        return users.map {
            User(
                name = it.userInfo?.last ?: "",
                firstname = it.userInfo?.first?: "",
                avatarProfil = it.picture?.thumbnail?: "",
                gender = it.gender,
                email = it.email,
                phone = it.phone,
                cell = it.cell, age = 10,
            )
        }
    }
}