package com.example.collpage

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeViewModel : ViewModel() {
    val currentUser = Firebase.auth.currentUser
}