package com.example.collpage.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

private const val TAG = "MyActivity"

class HomeViewModel : ViewModel() {
    private val db = Firebase.firestore
    private val currentUserId = Firebase.auth.currentUser?.uid
    var selectedItem by mutableStateOf("")
    var user by mutableStateOf(User())

    init {
        getUserData()
    }

    private fun getUserData() {
        db.collection("users").document(currentUserId.toString()).get()
            .addOnCompleteListener {
                user = it.result.toObject(User::class.java)!!
                Log.d(TAG, user.toString())
            }
    }

}

data class User(
    val email: String = "",
    val name: String = "",
    val occupation: String? = "",
    val profileDesc: String? = "",
    val username: String? = ""
)