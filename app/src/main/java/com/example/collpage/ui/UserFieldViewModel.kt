package com.example.collpage.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.example.collpage.helper.getDate

class UserFieldViewModel : ViewModel() {
    var title by mutableStateOf(TextFieldValue(""))
    var type by mutableStateOf(TextFieldValue(""))
    var startMonth by mutableStateOf(getDate("MMMM"))
    var endMonth by mutableStateOf(getDate("MMMM"))
    var startYear by mutableStateOf("2023")
    var endYear by mutableStateOf("2023")
    var description by mutableStateOf(TextFieldValue(""))
}