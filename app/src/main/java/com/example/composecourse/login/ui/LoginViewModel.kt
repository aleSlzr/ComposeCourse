package com.example.composecourse.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecourse.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _isLoginEnabled = MutableLiveData<Boolean>()
    private val _isLoading = MutableLiveData<Boolean>()
    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val isLoginEnabled: LiveData<Boolean> = _isLoginEnabled
    val isLoading: LiveData<Boolean> = _isLoading

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnabled.value = enableLogin(email, password)
    }

    private fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6
    }

    fun onLoginSelected() {
        viewModelScope.launch {
            _isLoading.value = true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                Log.i("Alia", "result: OK")
            } else {
                Log.e("Alia", "result: Error")
            }
            _isLoading.value = false
        }
    }

}