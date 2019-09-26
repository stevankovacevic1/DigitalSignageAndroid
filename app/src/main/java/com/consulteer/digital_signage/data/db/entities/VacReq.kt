package com.consulteer.digital_signage.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate


@Entity(tableName = "vacation")
data class VacReq(
    var idReq: Long? = null,
    val startDate: LocalDate,
    var endDate: LocalDate,
    var remDays: Int? = null,
    var reqDays: Int? = null



)
//@PrimaryKey(autoGenerate = true)
//var vrid: Long = REQUEST_PER_DEFAULT_USER