package com.consulteer.digital_signage.data.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.consulteer.digital_signage.data.db.entities.Event

@Dao/// this is using for accessing the current events with filo or asc sorting, need to tell to the project manager to make something to sort
interface EventDao{


    @Insert(onConflict= OnConflictStrategy.REPLACE)/// comunication with room and db and data fetched
    suspend fun saveAllEvent(events : List<Event>)

    @Query("SELECT * FROM Event")//// request to get that single event or events, by endpoint from id of event
    fun getEvents() : LiveData<List<Event>>


}