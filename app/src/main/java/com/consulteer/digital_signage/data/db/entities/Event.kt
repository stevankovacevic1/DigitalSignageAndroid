package com.consulteer.digital_signage.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


@Entity
data class Event(
    @PrimaryKey(autoGenerate = true)
    val title: String?,
    val description: String?,
    val locationEvent: String?,
    val startDate: LocalDateTime,
    var endDate: LocalDateTime?,
    val creationDate: LocalDateTime,
    var updateDate: LocalDateTime


    )