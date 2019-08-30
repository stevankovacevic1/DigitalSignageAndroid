package com.consulteer.digital_signage.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.SignInButton
import java.time.LocalDateTime

const val CURRENT_USER_ID = 0/// though whole seession that CURRENT USER ID becomes when someone logs in with consulteer extension mail


@Entity(tableName = "user")
data class User(
    var id: Long? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var username: String? = null,
    var password: String? = null,
    var email: String? = null,
    var status: String? = null,
    var role: String? = null,
    var birthday: LocalDateTime,
    var address: String? = null,
    val slava: LocalDateTime?,
    var number: String?,
    var remDaysVac: Int? = null

//    var singin: SignInButton,
//   val mGoogleSignInClient: GoogleSignInClient


//            enum class Role(role: String = guest)
//enum admin
//enum moderator
//enum user


) {
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID/// logged user id become primary key user session


}
