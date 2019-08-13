package com.consulteer.digital_signage.view.ui.home.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.consulteer.digital_signage.data.repositories.EventsRepository
import com.consulteer.digital_signage.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class EventsViewModelFactory(private val repository: EventsRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T{

        return EventsViewModel(repository) as T

    }




}