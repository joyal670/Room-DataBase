package com.example.ecom.ui.room

import androidx.lifecycle.LiveData
import androidx.room.*
import java.sql.SQLDataException

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<UserModelClass>>

    @Query("SELECT EXISTS(SELECT * FROM user WHERE user_email = :email)")
    fun isRecordExistsUserEmail(email: String?): Boolean

    @Query("SELECT EXISTS(SELECT * FROM user WHERE user_password = :password)")
    fun isRecordExistsUserPassword(password: String?): Boolean


    @Insert(onConflict = OnConflictStrategy.ABORT)
    @Throws(SQLDataException::class)
    suspend fun insertAll(userModelClass: UserModelClass)

    @Query("DELETE FROM user WHERE user_email = :email")
    fun delete(email: String?)

    @Query("UPDATE user SET user_name = :name, user_name = :name, user_password = :password WHERE user_email = :email")
    fun update(email: String?, name: String?, password: String?)

}
