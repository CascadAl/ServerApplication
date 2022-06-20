package com.example.serverapplication.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductItem(
    val name: String,
    val price: Double,
    val quantity: Int,
    val amount: Double
) : Parcelable