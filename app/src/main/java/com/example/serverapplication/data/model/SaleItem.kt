package com.example.serverapplication.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class SaleItem(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val number: String,
    val cashier: String,
    val items: List<ProductItem>,
    val payments: List<PaymentItem>
) : Parcelable {
    fun isInsufficientPayment() = items.sumOf { it.amount } == payments.sumOf { it.amount }
}
