package com.example.serverapplication.domain.entity.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReceiptResponse(
    val image: String
): Parcelable
