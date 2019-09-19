package com.consulteer.digital_signage.view.ui.home.profile.editProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.consulteer.digital_signage.data.repositories.UserRepository

@Suppress("UNCHEKED_CAST")
class EditProfileViewModelFactory(private val repository: UserRepository):
        ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EditProfileViewModel(repository)as T
    }
}