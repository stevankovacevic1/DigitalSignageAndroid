package com.consulteer.digital_signage.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.consulteer.digital_signage.data.db.entities.ReqDays

@Dao
interface ReqDaysDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllDaysReq(ReqDaysDao: List<ReqDays>)

    @Query("SELECT * FROM Vacation")
    fun getRemaningDays(): Int?
}