package com.consulteer.digital_signage.data.network.responses

import com.consulteer.digital_signage.data.db.entities.Event

data class EventResponse(


    val events: List<Event>,
    val existEvent: Boolean,
    val getEvent: Event

// exist event need to compare event if information are similar or same
)
