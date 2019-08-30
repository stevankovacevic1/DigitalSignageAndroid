package com.consulteer.digital_signage.view.ui.home.employees

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.consulteer.digital_signage.data.repositories.UserRepository

@Suppress("UNCHECKED_CAST")
class UsersViewModelFactory(private val repository: UserRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UsersViewModel(repository) as T
    }
}