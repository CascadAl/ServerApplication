package com.example.serverapplication.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serverapplication.server.ServerInitializer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val server: ServerInitializer
) : ViewModel() {

    fun initServer(dir: File) {
        viewModelScope.launch {
            server.initServerQuery(dir)
        }
    }

}