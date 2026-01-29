package com.omnissolutio.paymentsdk.network

import com.omnissolutio.paymentsdk.model.PaymentRequest
import com.omnissolutio.paymentsdk.model.PaymentResponse

interface PaymentApi {
    suspend fun createPayment(request: PaymentRequest): PaymentResponse
}