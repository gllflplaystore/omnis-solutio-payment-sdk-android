package com.omnissolutio.paymentsdk.security

import java.security.KeyPairGenerator

import android.util.Base64
import javax.crypto.Cipher

object EncryptionUtil {

    private val keyPair = KeyPairGenerator.getInstance("RSA").apply {
        initialize(1024)
    }.generateKeyPair()

    fun encrypt(data: String): String {
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.public)
        return Base64.encodeToString(cipher.doFinal(data.toByteArray()), Base64.NO_WRAP)
    }
}