package com.consulteer.digital_signage.data.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.consulteer.digital_signage.data.db.entities.Event

@Dao
interface EventDao{


    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun saveAllEvent(events : List<Event>)

    @Query("SELECT * FROM Event")
    fun getEvents() : LiveData<List<Event>>


}