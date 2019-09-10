package com.consulteer.digital_signage.view.ui.home.vacationReq

import androidx.lifecycle.ViewModel
import com.consulteer.digital_signage.data.repositories.VacationRepository
import com.consulteer.digital_signage.utill.lazyDeferred

class VacCalendarViewModel(repository: VacationRepository) : ViewModel() {
    val vacations by lazyDeferred() {
        repository.getVacations()
    }
}