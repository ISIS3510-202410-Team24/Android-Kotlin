package com.example.orderingfoodapp.screens.login.data

import com.example.orderingfoodapp.model.service.AccountService
import com.example.orderingfoodapp.screens.FoodAppViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val accountService: AccountService
) : FoodAppViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    fun updateEmail(newEmail: String) {
        email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        password.value = newPassword
    }

    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
        launchCatching {
            accountService.signIn(email.value, password.value)
//            openAndPopUp(NOTES_LIST_SCREEN, SIGN_IN_SCREEN)
        }
    }

//    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
//        openAndPopUp(SIGN_UP_SCREEN, SIGN_IN_SCREEN)
//    }
}