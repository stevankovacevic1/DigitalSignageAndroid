package com.consulteer.digital_signage.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Group(
    @PrimaryKey(autoGenerate = true)
    val name:String?,
    val description: String?,
    val logo : String?,
    val creationDate: LocalDateTime,
    var updateDate: LocalDateTime
)