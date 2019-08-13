package com.consulteer.digital_signage.view.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.consulteer.digital_signage.data.repositories.UserRepository
import com.consulteer.digital_signage.utill.ApiExpection
import com.consulteer.digital_signage.utill.Coroutines
import com.consulteer.digital_signage.utill.NoInternetException

class AuthViewModel(private val repository: UserRepository) : ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null
    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            ///dispatcher.main
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)

            } catch (e: ApiExpection) {
                authListener?.onFailure(e.message!!)
            }
            catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }


        }
    }

}


