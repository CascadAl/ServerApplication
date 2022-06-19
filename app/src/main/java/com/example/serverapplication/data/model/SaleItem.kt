package com.example.serverapplication.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SaleItem(
    val number: String,
    val cashier: String,
    val items: List<ProductItem>,
    val payments: List<PaymentItem>
) : Parcelable
