package com.example.serverapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.serverapplication.data.local.TerminalDatabase.Companion.DBVersion
import com.example.serverapplication.data.local.converters.PaymentConverter
import com.example.serverapplication.data.local.converters.ProductConverter
import com.example.serverapplication.data.model.SaleItem

@Database(
    entities = [SaleItem::class],
    version = DBVersion
)
@TypeConverters(
    value = [
        PaymentConverter::class,
        ProductConverter::class
    ]
)
abstract class TerminalDatabase : RoomDatabase() {

    abstract fun getSaleDao(): SaleDao

    companion object {
        const val DBVersion = 1
    }
}