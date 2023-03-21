package com.example.buddies.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.buddies.ui.screens.LoginPage
import com.example.buddies.ui.screens.SignUpPage
import com.example.buddies.ui.screens.WelcomePage

@Composable
fun CollioApp(navController: NavHostController = rememberNavController()) {
    AppNavHost(navController)
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.WelcomePage.route) {
        composable(Screen.WelcomePage.route) {
            WelcomePage(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginPage { navController.navigate(Screen.SignUp.route) }
        }
        composable(Screen.SignUp.route) {
            SignUpPage()
        }
    }
}