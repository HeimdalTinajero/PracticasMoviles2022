package com.example.practicaroomenclase

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicaroomenclase.database.DatabaseManager
import com.example.practicaroomenclase.database.MyCoroutines
import com.example.practicaroomenclase.database.User
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    fun saveUser(user: User){
        viewModelScope.launch {
            val userDao = DatabaseManager.instance.database.userDao()
            MyCoroutines(userDao).save(user)
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