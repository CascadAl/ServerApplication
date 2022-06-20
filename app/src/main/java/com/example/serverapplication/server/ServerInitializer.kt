package com.example.serverapplication.server

import java.io.File

interface ServerInitializer {
    fun initServerQuery(filesDir: File)
}