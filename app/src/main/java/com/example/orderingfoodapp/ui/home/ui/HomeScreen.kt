package com.example.orderingfoodapp.ui.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.google.android.material.bottomnavigation.BottomNavigationItemView

data class BottomNavigationBar (
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text( text = "HomeScreen" )
    }
}