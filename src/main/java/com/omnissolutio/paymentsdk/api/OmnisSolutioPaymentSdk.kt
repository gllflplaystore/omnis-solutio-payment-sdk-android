package com.omnissolutio.paymentsdk.api



import android.app.Activity
import android.content.Context
import android.util.Log
import com.omnissolutio.paymentsdk.callback.PaymentCallback
import com.omnissolutio.paymentsdk.model.PaymentRequest
import com.omnissolutio.paymentsdk.ui.PaymentActivity

object OmnisSolutioPaymentSdk {

    private lateinit var merchantKey: String
    private lateinit var appContext: Context

    fun initialize(context: Context, merchantKey: String) {
        this.appContext = context.applicationContext
        this.merchantKey = merchantKey
        Log.d("OmnisSDK", "SDK initialized")
    }

    fun startPayment(
        activity: Activity,
        request: PaymentRequest,
        callback: PaymentCallback
    ) {
        Log.d("OmnisSDK", "startPayment called")
        PaymentActivity.start(activity, request, callback)
    }
}