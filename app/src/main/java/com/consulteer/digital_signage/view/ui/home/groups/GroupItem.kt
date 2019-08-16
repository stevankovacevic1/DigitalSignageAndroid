package com.consulteer.digital_signage.view.ui.home.groups

import com.consulteer.digital_signage.R
import com.consulteer.digital_signage.data.db.entities.Group
import com.xwray.groupie.databinding.BindableItem

class GroupItem(
    private val group: Group
): BindableItem<ItemGroupBinding>(){
    override fun bind(viewBinding: ItemGroupBinding, position: Int) {
        viewBinding.setGroup(group)

    }

    override fun getLayout()= R.layout.item_group


}
