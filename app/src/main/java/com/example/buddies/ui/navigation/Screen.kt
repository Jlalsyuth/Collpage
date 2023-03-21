package com.example.buddies.ui.navigation

sealed class Screen(val route: String) {
    object WelcomePage: Screen("welcome")
}