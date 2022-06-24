package com.example.serverapplication.ui.main

import androidx.lifecycle.ViewModel
import com.example.serverapplication.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFragmentViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    suspend fun getAllReceipts() = repository.getAllSales()

}