package com.example.serverapplication.utils

import java.io.File

object FileManager {
    fun writeToFile(filePath: String, text: String?) {
        if (!text.isNullOrEmpty()) {
            val file = File(filePath)
            createFile(file)

            if (file.canWrite()) {
                file.writeText(text)
            }
        }
    }

    private fun createFile(file: File) {
        if (!file.exists()) {
            file.createNewFile()
        }
    }
}