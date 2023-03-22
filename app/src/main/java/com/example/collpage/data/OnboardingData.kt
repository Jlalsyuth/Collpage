package com.example.collpage.data

import androidx.annotation.DrawableRes

data class OnboardingData(
    @DrawableRes val imageId: Int,
    val shortDesc: String,
    val longDesc: String,
    val isLastPage: Boolean
)