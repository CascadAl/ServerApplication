package com.example.serverapplication.data.repository.impl

import com.example.serverapplication.data.local.SaleDao
import com.example.serverapplication.data.model.SaleItem
import com.example.serverapplication.data.repository.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepositoryImpl @Inject constructor(
    private val local: SaleDao
) : MainRepository {

    override fun saveSaleItem(item: SaleItem) = local.insert(item)

    override suspend fun getSaleItemById(id: Long) = local.getSaleById(id)

}