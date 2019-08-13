package com.consulteer.digital_signage.view.ui.home.profile

import androidx.lifecycle.ViewModel;
import com.consulteer.digital_signage.data.repositories.UserRepository

class ProfileViewModel(repository: UserRepository) : ViewModel() {
    val user = repository.getUser()

}
