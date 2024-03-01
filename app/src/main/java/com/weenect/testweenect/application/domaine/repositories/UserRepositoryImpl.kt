package com.weenect.testweenect.application.domaine.repositories

import com.weenect.testweenect.framework.data.locals.dao.UserDao
import com.weenect.testweenect.framework.data.remote.models.request.ParamBuilderQueryRequest
import com.weenect.testweenect.framework.data.remote.service.RemoteApiService
import com.weenect.testweenect.application.domaine.entities.User
import com.weenect.testweenect.application.domaine.entities.mapFromDto
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
               val users = data.results.map { it.mapFromDto() }
               userDao.insertAll(users)
               return@coroutineScope users
           }else {
              return@coroutineScope userDao.findAll()
           }
       }
    }

    override suspend fun getUser(uuid: String): User = userDao.find(uuid)

}