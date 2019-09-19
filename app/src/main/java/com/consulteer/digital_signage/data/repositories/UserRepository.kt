package com.consulteer.digital_signage.data.repositories

import com.consulteer.digital_signage.data.db.AppDatabase
import com.consulteer.digital_signage.data.db.entities.User
import com.consulteer.digital_signage.data.network.MyApi
import com.consulteer.digital_signage.data.network.responses.AuthResponse
import com.consulteer.digital_signage.data.network.responses.SafeApiRequest



class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {


    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }

        //return apiRequest{MyApi().userLogin(email, password)}
        //return MyApi().userLogin(email, password)

    }

    suspend fun saveUser(user: User) = db.getUserDao().updateInsert(user)

    fun getUser() = db.getUserDao().getUser()
    fun getAllUsers() = db.getUserDao().getAllUsers()
    fun getSearchedUser()= db.getUserDao().getSearchedUser()


}