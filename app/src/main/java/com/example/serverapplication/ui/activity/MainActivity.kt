package com.example.serverapplication.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.example.serverapplication.databinding.ActivityMainBinding
import com.example.serverapplication.server.ServerInitializer
import com.example.serverapplication.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    @Inject
    lateinit var server: ServerInitializer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            server.initServerQuery(filesDir)
        }
    }
}