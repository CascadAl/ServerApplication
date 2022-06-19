package com.example.serverapplication.data.local.converters

import androidx.room.TypeConverter
import com.example.serverapplication.common.LIST_DIVIDER
import com.example.serverapplication.common.STRING_DIVIDER
import com.example.serverapplication.data.model.PaymentItem

class PaymentConverter {

    @TypeConverter
    fun from(data: List<PaymentItem>): String {
        return data.joinToString {
            "${it.type}$STRING_DIVIDER" +
                    "${it.amount}$STRING_DIVIDER" +
                    "${it.change}$STRING_DIVIDER"
        }
    }

    @TypeConverter
    fun to(data: String): List<PaymentItem> {
        return if (data.isEmpty()) {
            emptyList()
        } else {
            val list = data.split(LIST_DIVIDER)
            val result = list.map {
                it.split(STRING_DIVIDER).let { item ->
                    PaymentItem(
                        type = item[0].trim(),
                        amount = item[1].trim().toDouble(),
                        change = item[2].trim().toDouble()
                    )
                }
            }
            result
        }
    }

}