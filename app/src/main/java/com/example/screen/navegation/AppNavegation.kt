package com.example.screen.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.screen.screens.LoginScreen
import com.example.screen.screens.SingUpScreen
import com.example.screen.screens.WelcomeScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("login"){
            LoginScreen(navController)
        }
        composable("welcome"){
            WelcomeScreen(navController)
        }
        composable("signup"){
            SingUpScreen(navController)
        }
    }
}
