package com.consulteer.digital_signage.data.db.entities

import androidx.room.Entity
import java.time.LocalDate


@Entity(tableName = "vacation")
data class VacReq(
    var idReq: Long? = null,
    val startDate: LocalDate,
    var endDate: LocalDate,
    var remDays: Int? = null,
    var reqDays: Int? = null



)
