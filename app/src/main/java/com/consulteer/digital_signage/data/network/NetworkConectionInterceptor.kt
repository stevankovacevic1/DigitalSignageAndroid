package com.consulteer.digital_signage.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.consulteer.digital_signage.utill.NoInternetException
import com.consulteer.digital_signage.view.ui.auth.LoginActivity
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(
context: Context

) :  Interceptor{


    private val applicationContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isInternetAvailable())
            throw NoInternetException("Digital Signage requires internet connection... ")

        return chain.proceed(chain.request())




    }
    private fun isInternetAvailable (): Boolean{/// in case there is no internet, we call service to check it
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetworkInfo.also {
            return it!= null && it.isConnected
        }


    }
}



