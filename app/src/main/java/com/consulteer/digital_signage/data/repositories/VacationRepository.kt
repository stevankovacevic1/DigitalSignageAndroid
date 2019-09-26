package com.consulteer.digital_signage.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.consulteer.digital_signage.data.db.AppDatabase
import com.consulteer.digital_signage.data.db.entities.VacReq
import com.consulteer.digital_signage.data.network.MyApi
import com.consulteer.digital_signage.data.network.responses.SafeApiRequest
import com.consulteer.digital_signage.data.preferences.PreferenceProvider
import com.consulteer.digital_signage.utill.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

private val CHECKING_VERSION_MINIMAL_INTERVAL = 90

class VacationRepository(
    private val api: MyApi,
    private val db: AppDatabase,
    private val preference: PreferenceProvider


) : SafeApiRequest() {
    private val vacation = MutableLiveData<List<VacReq>>()

    init {
        vacation.observeForever {
            saveVacation(it)
        }
    }

  suspend fun getVacations(): LiveData<List<VacReq>> {
        return withContext(Dispatchers.IO) {
            fetchVacations()
            db.getVacReqDao().getVacReqs()
        }
    }

    private suspend fun fetchVacations() {
        val lastSavedAt = preference.getLastSAvedAt()
        if (lastSavedAt == null || isFetchNeeded(LocalDateTime.parse(lastSavedAt))) {
            val response = apiRequest { api.getVacation() }
            vacation.postValue(response.)
        }
    }
    private fun isFetchNeeded(savedAt: LocalDateTime): Boolean{
        return ChronoUnit.MINUTES.between(savedAt,LocalDateTime.now())> CHECKING_VERSION_MINIMAL_INTERVAL
    }
    private fun saveVacation(vacations: List<VacReq>){
        Coroutines.io{
            preference.saveLastSavedAt(LocalDateTime.now().toString())
            db.getVacReqDao().saveAllVacReq(vacations)
        }
    }

}