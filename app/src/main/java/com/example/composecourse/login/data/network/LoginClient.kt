package com.example.composecourse.login.data.network

import com.example.composecourse.login.data.network.response.LoginResponse
import retrofit2.Response
import retrofit2.http.GET

interface LoginClient {
    @GET("/v3/0532945b-4a63-4b14-8e24-5f7d52cacefe")
    suspend fun doLogin(): Response<LoginResponse>
}