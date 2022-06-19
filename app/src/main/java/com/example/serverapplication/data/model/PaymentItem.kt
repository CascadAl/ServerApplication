package com.example.serverapplication.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PaymentItem(
    val type: String,
    val amount: Double,
    val change: Double
): Parcelable