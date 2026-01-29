package com.omnissolutio.paymentsdk.network

import com.omnissolutio.paymentsdk.model.PaymentRequest
import com.omnissolutio.paymentsdk.model.PaymentResponse
import kotlinx.coroutines.delay
import java.util.UUID

object ApiClient : PaymentApi {

    override suspend fun createPayment(request: PaymentRequest): PaymentResponse {
        // simulate network delay
        delay(1500)

        // return demo response
        return PaymentResponse(
            transactionId = UUID.randomUUID().toString(),
            status = "SUCCESS",
            message = "Payment successful (Demo)"
        )
    }
}