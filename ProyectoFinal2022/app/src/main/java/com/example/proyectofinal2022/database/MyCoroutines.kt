package com.example.proyectofinal2022.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines(private val userDao: UserDao) {
    suspend fun save(user: User) = withContext(Dispatchers.IO){
        userDao.save(user.toEntity())
    }

            suspend fun getSingleUser(uuid: String) = withContext(Dispatchers.IO){
        return@withContext userDao.getUserByUuid(uuid).toUser()
    }

    suspend fun delete(user:User) = withContext(Dispatchers.IO){
        userDao.delete(user.toEntity())
    }

    suspend fun getUsers(): LiveData<List<User>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(userDao.getUserFromDatabase().map {eachUserEntity->
            eachUserEntity.toUser()})
    }
}