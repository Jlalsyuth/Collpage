package com.example.collpage.helper

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun getInputColor(): Color {
    return if (isSystemInDarkTheme()) Color(0xFF262626) else Color(0xFFD9D9D9)
}

fun getDate(format: String): String {
    val cal = Calendar.getInstance()
    val monthDate = SimpleDateFormat(format)
    val formatted = monthDate.format(cal.time)
    return formatted.toString()
}