package com.example.ecom.ui.room

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecom.data.CategoryRepository

class RoomViewModel : ViewModel() {

    private var searchUserEmail = MutableLiveData<Int>()

    fun insertData(
        context: Context,
        userEmail: String,
        userName: String,
        userPassword: String
    ) {
        CategoryRepository.insertUserData(context, userEmail, userName, userPassword)
    }

    var liveUserData: LiveData<List<UserModelClass>>? = null

    fun getDetails(context: Context) :LiveData<List<UserModelClass>>? {
        liveUserData = CategoryRepository.getUserDetails(context)
        return liveUserData
    }

    fun deleteData(
        context: Context,
        userEmail: String
    ) {
        CategoryRepository.deleteUserData(context, userEmail)
    }

    fun updateData(
        context: Context,
        userEmail: String,
        userName: String,
        userPassword: String
    ) {
        CategoryRepository.updateUserData(context, userEmail, userName, userPassword)
    }

}