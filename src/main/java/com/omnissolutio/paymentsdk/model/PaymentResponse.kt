package com.omnissolutio.paymentsdk.model


data class PaymentResponse(
    val transactionId: String,
    val status: String,
    val message: String
)
