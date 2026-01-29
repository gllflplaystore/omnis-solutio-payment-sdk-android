package com.omnissolutio.paymentsdk.model

data class PaymentRequest(
    val amount: Double,
    val currency: String,
    val orderId: String,
    val customerId: String,
    val paymentMethod: PaymentMethod
)

enum class PaymentMethod {
    CARD,
    UPI
}
