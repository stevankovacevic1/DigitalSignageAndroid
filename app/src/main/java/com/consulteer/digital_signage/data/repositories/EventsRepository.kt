package com.consulteer.digital_signage.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.consulteer.digital_signage.data.db.AppDatabase
import com.consulteer.digital_signage.data.db.entities.Event
import com.consulteer.digital_signage.data.network.MyApi
import com.consulteer.digital_signage.data.network.responses.SafeApiRequest
import com.consulteer.digital_signage.data.preferences.PreferenceProvider
import com.consulteer.digital_signage.utill.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit


private val CHECKING_VERSION_MINIMAL_INTERVAL = 6
class EventsRepository(
    private val api: MyApi,
    private val db: AppDatabase,
    private val prefrerence: PreferenceProvider


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

    private suspend fun fetchEvent() {// ako je uzeo "nista" ili je potrebno tek da uzme, onda uzima api request sa responsom

        val lastSavedAt = prefrerence.getLastSAvedAt()

        if (lastSavedAt == null || isFetchNeeded(LocalDateTime.parse(lastSavedAt))) {
            val response = apiRequest { api.getEvents() }
            events.postValue(response.events)

        }
    }

    private fun isFetchNeeded(savedAt: LocalDateTime): Boolean {
        return ChronoUnit.HOURS.between(savedAt, LocalDateTime.now()) > CHECKING_VERSION_MINIMAL_INTERVAL//// proverava da li su svi podaci updatovani, na svakih 6 sati
    }

    private fun saveEvents(events: List<Event>) {
        Coroutines.io {

            prefrerence.saveLastSavedAt(LocalDateTime.now().toString())/// .now is min 26, this is 23
            db.getEventDao().saveAllEvent(events)/// uzima podatke za evente

        }


    }


}