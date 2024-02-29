package com.weenect.testweenect.application.domaine.repositories

import android.util.Log
import com.google.gson.Gson
import com.weenect.testweenect.framework.data.locals.dao.UserDao
import com.weenect.testweenect.framework.data.remote.models.request.ParamBuilderQueryRequest
import com.weenect.testweenect.framework.data.remote.models.response.UserResult
import com.weenect.testweenect.framework.data.remote.service.RemoteApiService
import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.helpers.CheckInternet
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class UserRepositoryImpl @Inject  constructor(
    private val remoteApiService: RemoteApiService,
    private val userDao: UserDao,
    private val checkInternet: CheckInternet
) : UserRepository {


    override suspend fun getUsers(page : Int): List<User> {
       return coroutineScope {
           if (checkInternet.isCheck()){
               val data = remoteApiService.getUser(
                   data = ParamBuilderQueryRequest()
                       .addParams(
                           "page" to page,
                           "results" to 10,
                           "seed" to "weenect"
                       )
               )
               val users = mapperUser(data.results)
               userDao.insertAll(users)
               return@coroutineScope users
           }else {
              return@coroutineScope userDao.findAll()
           }
       }
    }
    private fun mapperUser(users : List<UserResult>) : List<User> {
        return users.map {
            User(
                uuid = it.userLogin?.uuid?: generateRandom(10),
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

    fun generateRandom(length: Int): String {
        val charset = ('a'..'z') + ('A'..'Z') + ('0'..'9') // Define the character set you want to use
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }
}