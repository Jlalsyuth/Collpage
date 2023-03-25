package com.example.collpage.ui.navigation
import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.collpage.ui.AuthViewModel
import com.example.collpage.ui.screens.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun CollpageApp(navController: NavHostController = rememberNavController()) {
    AppNavHost(navController)
}

@Composable
fun AppNavHost(navController: NavHostController) {
    val auth: FirebaseAuth = Firebase.auth
    val startDestination = if (auth.currentUser != null) Screen.Home.route
    else Screen.WelcomePage.route
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.WelcomePage.route) {
            WelcomePage(navController = navController)
        }
        composable(Screen.Login.route) {
            LoginPage(
                navigateToSignUp = { navController.navigate(Screen.SignUp.route) },
                navigateToHome = { navController.navigate(Screen.Home.route) },
                navigateToForgotPass = { navController.navigate(Screen.ForgotPass.route) }
            )
        }
        composable(Screen.SignUp.route) { backStackEntry ->
            val viewModel: AuthViewModel = viewModel(backStackEntry)
            SignUpPage(viewModel) { navController.navigate(Screen.SignUp2.route) }
        }
        composable(Screen.SignUp2.route) {
            val viewModel: AuthViewModel = viewModel(navController.previousBackStackEntry!!)
            SignUpPage2(viewModel) { navController.navigate(Screen.Home.route) }
        }
        composable(Screen.Home.route) {
            HomeScreen {
                navController.navigate(Screen.WelcomePage.route) {
                    popUpTo(Screen.WelcomePage.route)
                }
            }
        }
        composable(Screen.ForgotPass.route) {
            ForgotPassword { navController.navigate(Screen.EmailCheck.route) }
        }
        composable(Screen.EmailCheck.route) {
            EmailCheck { navController.navigate(Screen.Login.route) }
        }
    }
}