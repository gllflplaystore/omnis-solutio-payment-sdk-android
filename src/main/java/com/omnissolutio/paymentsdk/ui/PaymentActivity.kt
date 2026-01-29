package com.omnissolutio.paymentsdk.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.omnissolutio.paymentsdk.callback.PaymentCallback
import com.omnissolutio.paymentsdk.model.PaymentError
import com.omnissolutio.paymentsdk.model.PaymentRequest
import com.omnissolutio.paymentsdk.model.PaymentResponse
import com.omnissolutio.paymentsdk.network.ApiClient
import com.omnissolutio.paymentsdk.security.EncryptionUtil
import com.omnissolutio.paymentsdk.util.Logger
import kotlinx.coroutines.launch

class PaymentActivity : ComponentActivity() {

    companion object {
        private var callback: PaymentCallback? = null
        private lateinit var request: PaymentRequest

        fun start(activity: Activity, paymentRequest: PaymentRequest, paymentCallback: PaymentCallback) {
            callback = paymentCallback
            request = paymentRequest
            activity.startActivity(Intent(activity, PaymentActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Logger.d("PaymentActivity started")

        processPayment()
    }

    private fun processPayment() {
        lifecycleScope.launch {
            try {
                val encrypted = EncryptionUtil.encrypt(request.orderId)
                Logger.d("Encrypted orderId: $encrypted")

                // Call demo backend API
                val response: PaymentResponse = ApiClient.createPayment(request)
                callback?.onSuccess(response)

            } catch (e: Exception) {
                callback?.onFailure(PaymentError(500, e.message ?: "Unknown error"))
            } finally {
                finish()
            }
        }
    }

    override fun onBackPressed() {
        callback?.onCancel()
        super.onBackPressed()
    }
}
