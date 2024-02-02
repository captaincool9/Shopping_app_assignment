package com.example.shoppingapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.shoppingapp.repository.UserRepository
import com.example.shoppingapp.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = AppDatabase.getDatabase(application).userDao()

    private val userRepository: UserRepository

    init {
        userRepository = UserRepository(userDao)
    }

    fun addUser(
        firstname: String,
        lastname: String,
        email: String,
        address: String,
        password: String,
        dob: String
    ) {
        userRepository.addUser(firstname,lastname,email,address,password, dob)
    }

    suspend fun checkCredentials(email: String, password: String): Boolean{
        return withContext(Dispatchers.IO){
            userDao.getUserByEmailAndPassword(email,password) != null
        }
    }
}
