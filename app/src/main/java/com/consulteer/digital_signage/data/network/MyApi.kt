package com.consulteer.digital_signage.data.network

import com.consulteer.digital_signage.data.db.entities.VacReq
import com.consulteer.digital_signage.data.network.responses.AuthResponse
import com.consulteer.digital_signage.data.network.responses.EventResponse
import com.consulteer.digital_signage.data.network.responses.GroupResponse
import com.consulteer.digital_signage.data.network.responses.UserResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

interface MyApi {
    //firstName, lastName,username,password,email,status,role
    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>

    @GET("events")
    suspend fun getEvents(): Response<EventResponse>

    @GET("groups")
    suspend fun getGroups() : Response<GroupResponse>

    @GET ("group/{id}")
    suspend fun getGroup() : Response<GroupResponse>

    @GET("event/{id}")
    suspend fun getEvent(): Response<EventResponse>

    @GET("users")
    suspend fun getAllUsers(): Response<UserResponse>

    @GET("vacations")
    suspend fun getVacation(): Response<VacReq>

    @FormUrlEncoded
    @PUT("user/{id}")
    suspend fun editUser(
        @Field ("role") role: String?,
        @Field ("status") status: String,
        @Field ("birthday") birthday:LocalDate,
        @Field("address") address: String?,
        @Field("slava") slava: LocalDate,
        @Field("number") number: String?
    ): Response<UserResponse>


    companion object {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor): MyApi {
            val okHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()




            return Retrofit.Builder()
                .client(okHttpclient)
                .baseUrl("{@customUrl}")//kada zavrse rest....
                .addConverterFactory(
                    GsonConverterFactory
                        .create()
                ).build()
                .create(MyApi::class.java)
        }


    }
}