package com.example.collpage.ui

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

sealed interface AuthUiState {
    object Success : AuthUiState
    object Error : AuthUiState
    object Default : AuthUiState
}

class AuthViewModel : ViewModel() {
    var email by mutableStateOf(TextFieldValue(""))
    var emailUsername by mutableStateOf(TextFieldValue(""))
    var username by mutableStateOf(TextFieldValue(""))
    var passwordConfirm by mutableStateOf(TextFieldValue(""))
    var password by mutableStateOf(TextFieldValue(""))
    var rememberMe by mutableStateOf(false)
    var isPasswordVisible by mutableStateOf(false)
    var isValidEmail by mutableStateOf(true)
        private set
    var authUiState: AuthUiState by mutableStateOf(AuthUiState.Default)
    var openTCDialog by mutableStateOf(false)
    var openConfirmDialog by mutableStateOf(false)


    var auth: FirebaseAuth = Firebase.auth
    private val db = Firebase.firestore

    fun handleLogin() {
        auth.signInWithEmailAndPassword(emailUsername.text, password.text)
            .addOnCompleteListener { task ->
                authUiState = if (task.isSuccessful) AuthUiState.Success else AuthUiState.Error
            }
    }

    fun handleSignup() {
        if (password.text != passwordConfirm.text) {
            authUiState = AuthUiState.Error
        }
        auth.createUserWithEmailAndPassword(email.text, password.text)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    authUiState = AuthUiState.Success
                    val user = hashMapOf(
                        "email" to email.text,
                        "username" to username.text,
                        "occupation" to "",
                        "profile_desc" to ""
                    )
                    auth.currentUser?.let { db.collection("users").document(it.uid).set(user) }
                }
            }
    }

    fun handleFirstSignup() {
        if (!Patterns.EMAIL_ADDRESS.matcher(email.text).matches()) {
            isValidEmail = false
            return
        }
        isValidEmail = true
    }
}