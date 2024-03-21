package com.example.orderingfoodapp.screens.home.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.Store
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem (
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems = listOf(
    NavItem(
        label = "Home",
        icon = Icons.Default.Home,
        route = Screens.HomeScreen.name
    ),
    NavItem(
        label = "Promotions",
        icon = Icons.Default.Percent,
        route = Screens.PromotionsScreen.name
    ),
    NavItem(
        label = "Restaurants",
        icon = Icons.Default.Store,
        route = Screens.RestaurantsScreen.name
    ),
    NavItem(
        label = "Orders",
        icon = Icons.Default.Notes,
        route = Screens.OrdersScreen.name
    )
)