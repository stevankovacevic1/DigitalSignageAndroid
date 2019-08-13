package com.consulteer.digital_signage.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.consulteer.digital_signage.data.db.AppDatabase
import com.consulteer.digital_signage.data.db.entities.Event
import com.consulteer.digital_signage.data.network.MyApi
import com.consulteer.digital_signage.data.network.responses.SafeApiRequest
import com.consulteer.digital_signage.utill.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventsRepository(
    private val api: MyApi,
    private val db: AppDatabase


) : SafeApiRequest() {
    private val events = MutableLiveData<List<Event>>()


    init {
        events.observeForever {
            saveEvents(it)
        }
    }

    suspend fun getEvents(): LiveData<List<Event>> {
        return withContext(Dispatchers.IO) {
            fetchEvent()
            db.getEventDao().getEvents()
        }


    }

    private suspend fun fetchEvent() {
        if (isFetchNeeded()) {
            val response = apiRequest { api.getEvents() }
            events.postValue(response.events)

        }
    }

    private fun isFetchNeeded(): Boolean {
        return true
    }

    private fun saveEvents(events: List<Event>) {
        Coroutines.io {

            db.getEventDao().saveAllEvent(events)

        }


    }


}