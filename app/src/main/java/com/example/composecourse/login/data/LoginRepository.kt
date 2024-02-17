package com.example.composecourse.login.data

import com.example.composecourse.login.data.network.LoginService
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {

    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(user, password)
    }
}