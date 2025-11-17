package com.range.animeWatch.common.service.impl


import com.range.animeWatch.common.service.EmailService
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(
    private val mailSender: JavaMailSender
) : EmailService {

    override fun sendPasswordResetEmail(email: String, resetLink: String) {
        val message = SimpleMailMessage()
        message.setTo(email)
        message.setSubject("Password Reset Request")
        message.setText("Click the link to reset your password: $resetLink")
        mailSender.send(message)
    }

    override fun sendTwoFactorCode(email: String, code: Int) {
        val message = SimpleMailMessage()
        message.setTo(email)
        message.setSubject("Your 2FA Code")
        message.setText("Your two-factor authentication code is: $code")
        mailSender.send(message)
    }

    override fun sendAccountBackEmail(email: String, token: String) {
        TODO("Not yet implemented")
    }
}
