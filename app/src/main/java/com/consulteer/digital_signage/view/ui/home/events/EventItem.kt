package com.consulteer.digital_signage.view.ui.home.events


import com.consulteer.digital_signage.R
import com.consulteer.digital_signage.data.db.entities.Event
import com.consulteer.digital_signage.databinding.ItemEventBinding
import com.xwray.groupie.databinding.BindableItem


class EventItem(
    private val event: Event
) : BindableItem<ItemEventBinding>() {
    override fun bind(viewBinding: ItemEventBinding, position: Int) {
        viewBinding.setEvent(event)
    }

    override fun getLayout() = R.layout.item_event

}