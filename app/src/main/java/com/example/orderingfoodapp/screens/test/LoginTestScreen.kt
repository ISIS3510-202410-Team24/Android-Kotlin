package com.example.orderingfoodapp.screens.test

import com.example.orderingfoodapp.screens.login.ui.SignInScreen
import com.example.orderingfoodapp.screens.login.ui.SignUpScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orderingfoodapp.R
import com.example.orderingfoodapp.screens.theme.OrderingFoodAppTheme

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
                    0 -> SignInScreen({ _, _ -> })
                    1 -> SignUpScreen({ _, _ -> })
                }
            }
        }
    }
}
data class TabItem(
    val title: String
)

/*
* package com.example.orderingfoodapp.screens.test

import com.example.orderingfoodapp.screens.login.ui.SignInScreen
import com.example.orderingfoodapp.screens.login.ui.SignUpScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orderingfoodapp.R
import com.example.orderingfoodapp.screens.theme.OrderingFoodAppTheme

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
                    0 -> SignInScreen({ _, _ -> })
                    1 -> SignUpScreen({ _, _ -> })
                }
            }
        }
    }
}
data class TabItem(
    val title: String
)
package com.example.orderingfoodapp.screens.test

import com.example.orderingfoodapp.screens.login.ui.SignInScreen
import com.example.orderingfoodapp.screens.login.ui.SignUpScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orderingfoodapp.R
import com.example.orderingfoodapp.screens.theme.OrderingFoodAppTheme

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
                    0 -> SignInScreen({ _, _ -> })
                    1 -> SignUpScreen({ _, _ -> })
                }
            }
        }
    }
}
data class TabItem(
    val title: String
)
package com.example.orderingfoodapp.screens.test

import com.example.orderingfoodapp.screens.login.ui.SignInScreen
import com.example.orderingfoodapp.screens.login.ui.SignUpScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orderingfoodapp.R
import com.example.orderingfoodapp.screens.theme.OrderingFoodAppTheme

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
                    0 -> SignInScreen({ _, _ -> })
                    1 -> SignUpScreen({ _, _ -> })
                }
            }
        }
    }
}
data class TabItem(
    val title: String
)
package com.example.orderingfoodapp.screens.test

import com.example.orderingfoodapp.screens.login.ui.SignInScreen
import com.example.orderingfoodapp.screens.login.ui.SignUpScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orderingfoodapp.R
import com.example.orderingfoodapp.screens.theme.OrderingFoodAppTheme

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
                    0 -> SignInScreen({ _, _ -> })
                    1 -> SignUpScreen({ _, _ -> })
                }
            }
        }
    }
}
data class TabItem(
    val title: String
)

* */
