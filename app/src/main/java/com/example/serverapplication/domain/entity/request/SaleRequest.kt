package com.example.serverapplication.domain.entity.request

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SaleRequest(
    val id: Int
): Parcelable
