package com.range.animeWatch.common.service

import org.springframework.stereotype.Service

@Service
interface EmailService {
    fun sendPasswordResetEmail(email: String, resetLink: String)
    fun sendTwoFactorCode(email: String, code: Int)
    fun sendAccountBackEmail(email: String, token: String)
}
