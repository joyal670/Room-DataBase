package com.example.ecom.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.ecom.ui.room.AppDatabase
import com.example.ecom.ui.room.UserModelClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CategoryRepository {

    companion object {
        var appDatabase: AppDatabase? = null
        var userModel: LiveData<List<UserModelClass>>? = null

        private fun initializeDB(context: Context): AppDatabase {
            return AppDatabase.getDatabaseClient(context)
        }

        fun insertUserData(
            context: Context,
            userEmail: String,
            userName: String,
            userPassword: String
        ) {
            appDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                val userDetails = UserModelClass(userEmail, userName, userPassword)
                appDatabase!!.userDao().insertAll(userDetails)
            }
        }

        fun getUserDetails(context: Context): LiveData<List<UserModelClass>>? {
            appDatabase = initializeDB(context)
            userModel = appDatabase!!.userDao().getAll()
            return userModel
        }

        fun deleteUserData(context: Context, userEmail: String) {
            appDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                appDatabase!!.userDao().delete(userEmail)
            }
        }

        fun updateUserData(
            context: Context,
            userEmail: String,
            userName: String,
            userPassword: String
        ) {
            appDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                appDatabase!!.userDao().update(userEmail, userName, userPassword)
            }
        }

    }
}