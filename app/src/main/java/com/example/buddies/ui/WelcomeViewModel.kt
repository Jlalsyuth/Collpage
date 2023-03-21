package com.example.buddies.ui

import androidx.lifecycle.ViewModel
import com.example.buddies.R
import com.example.buddies.data.OnboardingData

class WelcomeViewModel : ViewModel() {
    val onboardingItems = listOf(
        OnboardingData(
            R.drawable.collaboration,
            "Collaboration",
            "Let’s create a Space" + "\nFor your workflows",
            false
        ),
        OnboardingData(
            R.drawable.connection,
            "Connection",
            "Let’s make a relation with your teammates",
            false
        ),
        OnboardingData(
            R.drawable.communication,
            "Communication",
            "Let’s discuss a chat with your work group",
            true
        )
    )
}