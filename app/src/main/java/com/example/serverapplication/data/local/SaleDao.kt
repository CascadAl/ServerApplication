package com.example.serverapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.serverapplication.data.model.SaleItem

@Dao
interface SaleDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(item: SaleItem): Long

    @Query("SELECT * FROM SaleItem WHERE docId = :id")
    fun getSaleById(id: Long): SaleItem?

}