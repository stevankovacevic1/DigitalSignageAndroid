package com.consulteer.digital_signage.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

//primary key must contain sepreate abstract class with autogenerate off, bcuz when current user logs the session with FILO
@Entity(tableName = "event")
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