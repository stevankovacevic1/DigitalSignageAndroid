package com.consulteer.digital_signage.view.ui.auth

import androidx.lifecycle.LiveData
import com.consulteer.digital_signage.data.db.entities.User

interface AuthListener {


    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}
