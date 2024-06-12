package com.example.rangtech.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rangtech.models.User
import com.example.rangtech.repository.InspectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: InspectionRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<Result<Unit>?>(null)
    val loginState: StateFlow<Result<Unit>?> = _loginState.asStateFlow()

    private val _registerState = MutableStateFlow<Result<Unit>?>(null)
    val registerState: StateFlow<Result<Unit>?> = _registerState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.login(User(email, password))
                if (response.isSuccessful) {
                    _loginState.value = Result.success(Unit)
                } else {
                    _loginState.value = Result.failure(HttpException(response))
                }
            } catch (e: Exception) {
                _loginState.value = Result.failure(e)
            }
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = repository.register(User(email, password))
                if (response.isSuccessful) {
                    _registerState.value = Result.success(Unit)
                } else {
                    _registerState.value = Result.failure(HttpException(response))
                }
            } catch (e: Exception) {
                _registerState.value = Result.failure(e)
            }
        }
    }
}