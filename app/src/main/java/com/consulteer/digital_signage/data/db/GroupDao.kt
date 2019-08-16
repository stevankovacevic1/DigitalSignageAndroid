package com.consulteer.digital_signage.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.consulteer.digital_signage.data.db.entities.Group

@Dao
interface GroupDao
{


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllGroup(groups: List<Group>)

    @Query("SELECT * FROM Group")
    fun getGroups(): LiveData<List<Group>>

}