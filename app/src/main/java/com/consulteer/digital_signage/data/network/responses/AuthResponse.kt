package com.consulteer.digital_signage.data.network.responses

import com.consulteer.digital_signage.data.db.entities.User

data class AuthResponse (
    val isSuccessful: Boolean,
    val message: String?,
    val user: User?






)