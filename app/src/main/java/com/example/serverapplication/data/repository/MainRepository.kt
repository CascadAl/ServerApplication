package com.example.serverapplication.data.repository

import androidx.lifecycle.LiveData
import com.example.serverapplication.data.model.SaleItem

interface MainRepository {
    fun saveSaleItem(item: SaleItem): Long
    suspend fun getSaleItemById(id: Long): SaleItem?
    suspend fun getAllSales(): LiveData<List<SaleItem>>?
}