package com.example.randomprofile.API

import com.example.randomprofile.entities.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET(".")
    suspend fun getUsers(): Response<UserResponse>

}