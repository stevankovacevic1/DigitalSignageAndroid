package com.consulteer.digital_signage.view.ui.home.groups


import androidx.lifecycle.ViewModel
import com.consulteer.digital_signage.data.repositories.GroupRepository
import com.consulteer.digital_signage.utill.lazyDeferred

class GroupsViewModel(repository: GroupRepository): ViewModel(){
    val groups by lazyDeferred(){
        repository.getGroups()
    }
}