package com.example.serverapplication.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
@JacksonXmlRootElement(localName = "Receipt")
data class SaleItem(
    @PrimaryKey(autoGenerate = true)
    val docId: Long,
    @SerializedName("number")
    val docNumber: String,
    val cashier: String,
    @field:JacksonXmlElementWrapper(localName = "items")
    @field:JacksonXmlProperty(localName = "item")
    val items: List<ProductItem>,
    @field:JacksonXmlElementWrapper(localName = "payments")
    @field:JacksonXmlProperty(localName = "payment")
    val payments: List<PaymentItem>
) : Parcelable
