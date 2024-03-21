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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.orderingfoodapp.R

@Composable
fun SignInScreen() {
    // Inputs para correo y contraseña
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column {
        TextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
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
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
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
            onClick = { /* Do Something */ },
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

