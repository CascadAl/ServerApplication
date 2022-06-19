package com.example.serverapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.serverapplication.R
import com.example.serverapplication.server.initServerQuery

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initServerQuery()
    }
}