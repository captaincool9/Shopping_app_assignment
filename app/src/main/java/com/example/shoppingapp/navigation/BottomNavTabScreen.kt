package com.example.shoppingapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavTabScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavTabScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomNavTabScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}
