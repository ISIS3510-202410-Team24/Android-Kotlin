package com.example.orderingfoodapp.screens.login.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orderingfoodapp.APP_NAVIGATION
import com.example.orderingfoodapp.LOGIN_SCREEN
import com.example.orderingfoodapp.model.service.AccountService
import com.example.orderingfoodapp.model.service.impl.AccountServiceImpl
import com.example.orderingfoodapp.screens.FoodAppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    val accountService = AccountServiceImpl()


    fun updateUsername(newUsername: String) {
        _username.value = newUsername
    }
    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun launchCatching(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch(
            CoroutineExceptionHandler() { _, throwable ->
                Log.d(ERROR_TAG, throwable.message.orEmpty())
            },
            block = block
        )

    companion object {
        const val ERROR_TAG = "FOOD APP ERROR"
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
//            if (!_email.value.isValidEmail()) {
//                throw IllegalArgumentException("Invalid email format")
//            }
//
//            if (!_password.value.isValidPassword()) {
//                throw IllegalArgumentException("Invalid password format")
//            }

            accountService.signUp(_email.value, _password.value)
            openAndPopUp(APP_NAVIGATION, LOGIN_SCREEN)
        }
    }
}