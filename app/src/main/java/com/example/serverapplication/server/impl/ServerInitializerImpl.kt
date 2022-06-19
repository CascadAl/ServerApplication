package com.example.serverapplication.server.impl

import com.example.serverapplication.common.*
import com.example.serverapplication.data.model.SaleItem
import com.example.serverapplication.data.repository.MainRepository
import com.example.serverapplication.domain.entity.request.SaleRequest
import com.example.serverapplication.domain.entity.response.ReceiptResponse
import com.example.serverapplication.domain.entity.response.Response
import com.example.serverapplication.domain.entity.response.SaleResponse
import com.example.serverapplication.server.ServerInitializer
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import javax.inject.Inject

class ServerInitializerImpl @Inject constructor(
    private val repository: MainRepository
) : ServerInitializer {

    override fun initServerQuery() {
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
                val status: Response = if (item.isInsufficientPayment()) {
                    val index = repository.saveSaleItem(item)
                    Response.Success(
                        data = SaleResponse(id = index)
                    )
                } else {
                    Response.Error(
                        message = PAY_AMOUNT_ERROR
                    )
                }
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
                val saleItem = repository.getSaleItemById(item.id)
                val status: Response = saleItem?.let {
                    Response.Success(
                        data = ReceiptResponse(image = it.number)
                    )
                } ?: run {
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
}