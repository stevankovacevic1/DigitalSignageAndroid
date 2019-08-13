package com.consulteer.digital_signage.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID=0


@Entity(tableName= "user")
data class User(
    var id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    var status: String? = null,
    var role:String? = null


//            enum class Role(role: String = guest)
//enum admin
//enum moderator
//enum user


){
    @PrimaryKey(autoGenerate= false)
    var uid:Int = CURRENT_USER_ID





}
