package com.example.collpage.ui.navigation

sealed class Screen(val route: String) {
    object WelcomePage: Screen("welcome")
    object Login: Screen("login")
    object SignUp: Screen("SignUp")
}