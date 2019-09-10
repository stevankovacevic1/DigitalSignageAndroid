package com.consulteer.digital_signage.data.db.entities

import androidx.room.Entity


@Entity(tableName = "requestother")
data class ReqDays(


    var remDays: Int? = null,
    var relocationDay: Int = 1,
    var examineDay: Int? = 2,
    var deathDay: Int?= 5,
    val bornDay: Int = 5


)