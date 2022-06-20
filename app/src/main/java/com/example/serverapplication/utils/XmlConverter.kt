package com.example.serverapplication.utils

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator

object XmlConverter {
    fun <T> fromItemToXml(item: T): String {
        val xmlMapper = XmlMapper(
            JacksonXmlModule().apply {
                setDefaultUseWrapper(true)
            }
        ).apply {
            enable(SerializationFeature.INDENT_OUTPUT)
            enable(SerializationFeature.WRAP_ROOT_VALUE)
            enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION)
        }

        return xmlMapper.writeValueAsString(item)
    }
}