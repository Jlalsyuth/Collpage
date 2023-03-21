package com.example.buddies.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    var emailUsername by mutableStateOf(TextFieldValue(""))
    var password by mutableStateOf(TextFieldValue(""))
}