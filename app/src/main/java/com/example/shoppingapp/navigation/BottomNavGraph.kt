package com.example.shoppingapp.navigation

import ProfileScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoppingapp.view.HomeScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavTabScreen.Home.route
    ) {
        composable(route = BottomNavTabScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomNavTabScreen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
