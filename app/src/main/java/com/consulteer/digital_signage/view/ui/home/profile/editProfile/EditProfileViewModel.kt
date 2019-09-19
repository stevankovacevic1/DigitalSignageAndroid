package com.consulteer.digital_signage.view.ui.home.profile.editProfile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.consulteer.digital_signage.data.db.entities.User
import com.consulteer.digital_signage.data.repositories.UserRepository

class EditProfileViewModel (repository:UserRepository): ViewModel(){
    val user:LiveData<User> = repository.getSearchedUser()
}