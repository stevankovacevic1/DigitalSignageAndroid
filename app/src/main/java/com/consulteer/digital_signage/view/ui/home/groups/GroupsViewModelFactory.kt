package com.consulteer.digital_signage.view.ui.home.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.consulteer.digital_signage.data.repositories.GroupRepository

@Suppress ("UNCHECKED_CAST")
class GroupsViewModelFactory(
    private val repository: GroupRepository):ViewModelProvider.NewInstanceFactory(){
    override fun<T: ViewModel?> create (modelClass: Class<T>): T{
        return GroupsViewModel(repository)as T
    }
}
