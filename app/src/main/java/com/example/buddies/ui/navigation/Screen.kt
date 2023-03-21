package com.example.buddies.ui.navigation

sealed class Screen(val route: String) {
    object WelcomePage: Screen("welcome")
    object Login: Screen("login")
    object SignUp: Screen("SignUp")
}