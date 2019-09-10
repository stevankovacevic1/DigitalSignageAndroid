package com.consulteer.digital_signage.view.ui.home.vacationReq

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.consulteer.digital_signage.data.repositories.VacationRepository

@Suppress ("UNCHECKED CAST")
class VacCalendarViewModelFactory (private val repository: VacationRepository): ViewModelProvider.NewInstanceFactory(){
    override fun <T: ViewModel?> create (modelClass: Class<T>): T{
        return VacCalendarViewModel(repository) as T
    }
}