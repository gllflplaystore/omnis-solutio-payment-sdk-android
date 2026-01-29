package com.omnissolutio.paymentsdk.util

import android.util.Log

object Logger {
    private const val TAG = "OmnisSolutioPaymentSdk"

    fun d(message: String) {
        Log.d(TAG, message)
    }

    fun e(message: String) {
        Log.e(TAG, message)
    }
}