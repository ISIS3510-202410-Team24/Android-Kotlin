package com.example.orderingfoodapp.screens.login.data

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.orderingfoodapp.APP_NAVIGATION
import com.example.orderingfoodapp.SIGN_IN_SCREEN
import com.example.orderingfoodapp.model.service.impl.AccountServiceImpl
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SignInViewModel : ViewModel() {

    val email = MutableStateFlow("")
    val password = MutableStateFlow("")
    val accountService = AccountServiceImpl()

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword
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

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            accountService.signIn(email.value, password.value)
            openAndPopUp(APP_NAVIGATION, SIGN_IN_SCREEN)
        }
    }
}