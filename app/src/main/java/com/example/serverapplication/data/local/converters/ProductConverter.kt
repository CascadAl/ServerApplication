package com.example.serverapplication.data.local.converters

import androidx.room.TypeConverter
import com.example.serverapplication.common.LIST_DIVIDER
import com.example.serverapplication.common.STRING_DIVIDER
import com.example.serverapplication.data.model.ProductItem

class ProductConverter {

    @TypeConverter
    fun from(data: List<ProductItem>): String {
        return data.joinToString {
            "${it.name}$STRING_DIVIDER" +
                    "${it.price}$STRING_DIVIDER" +
                    "${it.quantity}$STRING_DIVIDER" +
                    "${it.amount}$STRING_DIVIDER"
        }
    }

    @TypeConverter
    fun to(data: String): List<ProductItem> {
        return if (data.isEmpty()) {
            emptyList()
        } else {
            val list = data.split(LIST_DIVIDER)
            val result = list.map {
                it.split(STRING_DIVIDER).let { item ->
                    ProductItem(
                        name = item[0].trim(),
                        price = item[1].trim().toDouble(),
                        quantity = item[2].trim().toInt(),
                        amount = item[3].trim().toDouble()
                    )
                }
            }
            result
        }
    }

}