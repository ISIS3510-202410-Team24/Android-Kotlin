package com.example.orderingfoodapp.screens.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.orderingfoodapp.R
import com.example.orderingfoodapp.screens.login.data.SignInViewModel

@Composable
fun SignInScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = viewModel()
) {
    // Inputs para correo y contraseña
    // val emailState = remember { mutableStateOf("") }
    // val passwordState = remember { mutableStateOf("") }

    val email = viewModel.email.collectAsState()
    val password = viewModel.password.collectAsState()

    Column {
        TextField(
            value = email.value,
            onValueChange = { viewModel.updateEmail(it) },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            leadingIcon = {
                Icon (
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )
            }
        )

        TextField(
            value = password.value,
            onValueChange = { viewModel.updatePassword(it) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Send),
            singleLine = true,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            leadingIcon = {
                Icon (
                    imageVector = Icons.Default.Lock,
                    contentDescription = null
                )
            }
        )

        Button(
            onClick = { viewModel.onSignInClick(openAndPopUp) },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text("Log in")
        }
        Text(
            text = "Forgot password?",
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.End)
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column (modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Center) {
                Divider(
                    modifier = Modifier
//                        .padding(horizontal = 8.dp)
                        .height(1.dp)
                        .background(Color.Gray)
                        .fillMaxWidth()
                )
            }
            Column (modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                Text( text = "Or login with", textAlign = TextAlign.Center)
            }
            Column (modifier = Modifier.weight(1f)) {
                Divider(
                    modifier = Modifier
//                        .padding(horizontal = 8.dp)
                        .height(1.dp)
                        .background(Color.Gray)
                        .fillMaxWidth()
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 16.dp)) {
            Image(painter = painterResource(R.drawable.google), contentDescription = "Google Icon", modifier = Modifier
                .width(48.dp)
                .height(48.dp))
        }
    }
}

