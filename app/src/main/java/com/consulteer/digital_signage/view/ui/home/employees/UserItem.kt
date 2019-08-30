package com.consulteer.digital_signage.view.ui.home.employees

import com.consulteer.digital_signage.R
import com.consulteer.digital_signage.data.db.entities.User
import com.consulteer.digital_signage.databinding.ItemUsersBinding
import com.xwray.groupie.databinding.BindableItem

class UserItem (
    private val user: User
):BindableItem<ItemUsersBinding>(){
    override  fun bind(viewBinding:ItemUsersBinding, position:Int){
        viewBinding.setUsers(user)

    }

    override fun getLayout()= R.layout.item_users


}
