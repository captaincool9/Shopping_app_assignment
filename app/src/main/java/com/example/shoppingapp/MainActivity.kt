package com.example.shoppingapp

import SignInScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.ui.theme.ShoppingAppTheme
import com.example.shoppingapp.view.MainScreen
import com.example.shoppingapp.view.SignUpScreen
import com.example.shoppingapp.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ShoppingAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {

                    val navController = rememberNavController()
                    val productViewModel: ProductViewModel by viewModels()

                    NavHost(navController = navController, startDestination = "sign_in") {
                        composable("sign_in") {
                            SignInScreen(navController, productViewModel)
                        }
                        composable("sign_up") {
                            SignUpScreen(navController)
                        }
                        composable("Home_Screen") {
                            MainScreen(navController)
                        }
                    }
                }
            }
        }
    }
}




