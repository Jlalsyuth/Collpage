package com.example.buddies.data

import androidx.annotation.DrawableRes

data class OnboardingData(
    @DrawableRes val imageId: Int,
    val shortDesc: String,
    val longDesc: String,
    val isLastPage: Boolean
)