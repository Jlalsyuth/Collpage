package com.example.collpage.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SearchViewModel : ViewModel() {
    private val db = Firebase.firestore
    var query by mutableStateOf("")

    private val _jobslist = mutableStateListOf<Job>()
    val jobsList: List<Job> = _jobslist

    fun getJobResults() {

    }
}

data class Job(
    val name: String,
    val company_id: String,
    val placement: String,
    val salary_range: String,
    val type: String
)