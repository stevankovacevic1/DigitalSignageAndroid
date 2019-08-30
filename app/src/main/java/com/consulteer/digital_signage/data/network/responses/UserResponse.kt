package com.consulteer.digital_signage.data.network.responses

import com.consulteer.digital_signage.data.db.entities.User

data class UserResponse(


    val getAllUsers: List<User>,
    val user: User?





)