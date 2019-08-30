package com.consulteer.digital_signage.view.ui.home.employees

import androidx.lifecycle.ViewModel
import com.consulteer.digital_signage.data.repositories.UserRepository
import com.consulteer.digital_signage.utill.lazyDeferred

class UsersViewModel (
    repository: UserRepository

): ViewModel(){

    val users by lazyDeferred(){
        repository.getAllUsers()
    }
}