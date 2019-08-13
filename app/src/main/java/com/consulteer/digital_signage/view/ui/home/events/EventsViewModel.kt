package com.consulteer.digital_signage.view.ui.home.events

import androidx.lifecycle.ViewModel;
import com.consulteer.digital_signage.data.repositories.EventsRepository
import com.consulteer.digital_signage.utill.lazyDeferred


class EventsViewModel(
    repository:EventsRepository
):ViewModel(){

    val events by lazyDeferred() {

        repository.getEvents()
    }/// because on main thread there is another function that need to be run first,, only when is need it call
    /// cant call suspended function directly



}