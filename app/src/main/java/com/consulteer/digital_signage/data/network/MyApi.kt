package com.consulteer.digital_signage.data.network

import com.consulteer.digital_signage.data.network.responses.AuthResponse
import com.consulteer.digital_signage.data.network.responses.EventResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MyApi {
    //firstName, lastName,username,password,email,status,role
    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    )
            : Response<AuthResponse>

    @GET("events")
    suspend fun getEvents(): Response<EventResponse>


    companion object {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): MyApi {
            val okHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()




            return Retrofit.Builder()
                .client(okHttpclient)
                .baseUrl("{@customUrl}")//change
                .addConverterFactory(
                    GsonConverterFactory
                        .create()
                ).build()
                .create(MyApi::class.java)
        }


    }
}