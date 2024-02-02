package com.example.shoppingapp.repository

import com.example.shoppingapp.database.User
import com.example.shoppingapp.database.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {
    private val coroutineScope= CoroutineScope(Dispatchers.Main)

    fun addUser(firstname: String, lastname: String, email: String, address: String, password: String, dob:String) {
        coroutineScope.launch(Dispatchers.IO) {
            val user = User(firstName = firstname,lastName = lastname,  email = email, address = address, password=password,  dob = dob)
            userDao.addUser(user)
        }
    }
}