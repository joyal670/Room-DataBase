package com.example.ecom.ui.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserModelClass(

    @PrimaryKey
    @ColumnInfo(name = "user_email") var userEmail: String,
    @ColumnInfo(name = "user_name") var userName: String,
    @ColumnInfo(name = "user_password") var userPassword: String

)
