package com.example.beautySalon.Managers

class LoginScreenManager {
    var isSentCode = false

    fun sendCode(phoneNumber: String): Boolean {
        // здесь надо делать запрос на сервер и ждать, что придет успех или не успех, сейчас у нас
        // всегда придет успех
        isSentCode = true
        return true
    }

    fun sheckCode(code: String): Boolean {
        // здесь надо делать запрос на сервер и ждать, что придет успех или не успех, сейчас у нас
        // всегда придет успех
        return true
    }
}