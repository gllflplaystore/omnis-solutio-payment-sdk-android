package com.omnissolutio.paymentsdk.callback

import com.omnissolutio.paymentsdk.model.PaymentError
import com.omnissolutio.paymentsdk.model.PaymentResponse


interface PaymentCallback {
    fun onSuccess(response: PaymentResponse)
    fun onFailure(error: PaymentError)
    fun onCancel()
}