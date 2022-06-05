package com.example.proyectofinal2022

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal2022.database.User
import com.example.proyectofinal2022.database.DatabaseManager
import com.example.proyectofinal2022.database.MyCoroutines
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    fun saveUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).save(user)
        }
    }

    fun getuserbyid(s: String) {
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).getSingleUser(s)
        }
    }


    fun deleteUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).delete(user)
        }
    }

    val savedUsers = MutableLiveData<List<User>>()
    fun getUser(){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            savedUsers.value = MyCoroutines(userDao).getUsers().value
        }
    }
}