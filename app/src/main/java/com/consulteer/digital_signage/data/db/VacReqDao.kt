package com.consulteer.digital_signage.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.consulteer.digital_signage.data.db.entities.VacReq

@Dao
interface VacReqDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun saveAllVacReq(vacReqDao: List<VacReq>)

    @Query("SELECT * FROM vacation")
    fun getVacReqs(): LiveData<List<VacReq>>

    @Query("SELECT * FROM vacation WHERE ")


}