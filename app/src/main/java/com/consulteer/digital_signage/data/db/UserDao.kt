package com.consulteer.digital_signage.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.consulteer.digital_signage.data.db.entities.CURRENT_USER_ID
import com.consulteer.digital_signage.data.db.entities.User


@Dao
interface UserDao {


    //insert the user
    @Insert(onConflict = OnConflictStrategy.REPLACE)//in case if same id user
    suspend fun updateInsert(user: User): Long

    // get user crud
    @Query("SELECT * FROM user WHERE uid= $CURRENT_USER_ID")// explained in user entity, also used for checking other user profile
    fun getUser(): LiveData<User>

    @Query("SELECT * FROM user")
    fun getAllUsers(): LiveData<List<User>>


}