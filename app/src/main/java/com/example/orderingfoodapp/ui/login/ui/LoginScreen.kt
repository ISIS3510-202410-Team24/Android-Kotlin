package com.example.orderingfoodapp.ui.login.ui

import android.graphics.drawable.Icon
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.orderingfoodapp.R
import com.google.android.material.tabs.TabLayout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.style.TextAlign

@Composable
fun LoginScreen() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            HeaderImage()
        }
        Row(Modifier.weight(1f)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                Login()
            }
        }
    }

}

@Composable
fun Login() {
    Column {
        TabOptions()
    }
}

@Composable
fun EmailField() {
    TextField(value = "", onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        textStyle = TextStyle(color = Color.White)
    )
}

@Composable
fun HeaderImage() {
    Image(painter = painterResource(id = R.drawable.salad), contentDescription = null)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabOptions() {
    val tabItem = listOf(
        TabItem(
            title = "Sign in"
        ),
        TabItem(
            title = "Sign up"
        )
    )
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        tabItem.size
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if(!pagerState.isScrollInProgress) {
            selectedTabIndex = pagerState.currentPage
        }
    }

    Column(Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItem.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = item.title) }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {index ->
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                when (index) {
                    0 -> SignInContent()
                    1 -> SignUpContent()
                }
            }
        }
    }
}

@Composable
private fun SignInContent() {
    // Inputs para correo y contraseña
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(
//        modifier = Modifier.fillMaxWidth(),
    ) {
        TextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            leadingIcon = {
                Icon (
                    painter = painterResource(R.drawable.baseline_person_24),
                    contentDescription = null
                )
            }
        )

        TextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            leadingIcon = {
                Icon (
                    painter = painterResource(R.drawable.baseline_lock_24),
                    contentDescription = null
                )
            }
        )

        Button(
            onClick = { /* Implementar el inicio de sesión */ },
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
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)) {
            Image(painter = painterResource(R.drawable.google), contentDescription = "Google Icon", modifier = Modifier.width(48.dp).height(48.dp))
        }
    }
}

@Composable
private fun SignUpContent() {
    // Inputs para nombre, correo y contraseña
    val nameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(
            value = nameState.value,
            onValueChange = { nameState.value = it },
            label = { Text("Name") }
        )

        TextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") }
        )

        TextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Password") }
        )

        Button(
            onClick = { /* Implementar el registro */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Sign Up")
        }
    }
}




data class TabItem(
    val title: String
)


