package com.example.collpage.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.example.collpage.helper.getDate

sealed interface FieldUiState {
    object Success : FieldUiState
    object Loading : FieldUiState
    object Default : FieldUiState
}

class UserFieldViewModel : ViewModel() {
    var projectTitle by mutableStateOf(TextFieldValue(""))
    var projectType by mutableStateOf(TextFieldValue(""))
    var startMonth by mutableStateOf(getDate("MMMM"))
    var endMonth by mutableStateOf(getDate("MMMM"))
    var startYear by mutableStateOf("2023")
    var endYear by mutableStateOf("2023")
    var description by mutableStateOf(TextFieldValue(""))

    var almamaterName by mutableStateOf(TextFieldValue(""))
    var yearIn by mutableStateOf("2023")
    var yearOut by mutableStateOf("2023")
    var major by mutableStateOf("Bidang")
    var eduActivity by mutableStateOf(TextFieldValue(""))

    var experienceName by mutableStateOf(TextFieldValue(""))
    var position by mutableStateOf(TextFieldValue(""))
}