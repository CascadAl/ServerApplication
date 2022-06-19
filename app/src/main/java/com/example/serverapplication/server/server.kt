package com.example.serverapplication.server

import com.example.serverapplication.common.*
import com.example.serverapplication.data.model.SaleItem
import com.example.serverapplication.domain.entity.request.SaleRequest
import com.example.serverapplication.domain.entity.response.ReceiptResponse
import com.example.serverapplication.domain.entity.response.Response
import com.example.serverapplication.domain.entity.response.SaleResponse
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

private val saleItem = mutableListOf<SaleItem>()

fun initServerQuery() {
    embeddedServer(
        factory = Netty,
        port = PORT
    ) {
        install(ContentNegotiation) {
            gson {}
        }
        routing {
            createSupportedOperationsQuery(this)
            createSaleQuery(this)
            createReceiptQuery(this)
        }
    }.start(wait = true)
}

private fun createSupportedOperationsQuery(routing: Routing) {
    routing.get(SUPPORTED_OPERATIONS) {
        val status = Response.Success(data = operations)
        call.respond(status)
    }
}

private fun createSaleQuery(routing: Routing) {
    routing.post(SALE) {
        try {
            val item = call.receive<SaleItem>()
            saleItem.add(item)
            val index = saleItem.indexOf(item)
            val status = Response.Success(
                data = SaleResponse(id = index)
            )
            call.respond(status)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

private fun createReceiptQuery(routing: Routing) {
    routing.post(RECEIPT) {
        try {
            val item = call.receive<SaleRequest>()
            val status: Response = if (item.id in 0 until saleItem.size) {
                val sItem = saleItem[item.id]
                Response.Success(
                    data = ReceiptResponse(image = sItem.number)
                )
            } else {
                Response.Error(
                    message = RECEIPT_NOT_FOUND_ERROR
                )
            }
            call.respond(status)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}