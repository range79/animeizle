package com.range.userservice.service.impl

import com.range.userservice.domain.entity.PasswordResetToken
import com.range.userservice.domain.repository.PasswordResetTokenRepository
import com.range.userservice.service.PasswordTokenService
import jakarta.mail.internet.MimeMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine

@Service
class PasswordTokenService(
    private val repository: PasswordResetTokenRepository,
    private val mailSender: JavaMailSender,
    private val templateEngine: SpringTemplateEngine
) : PasswordTokenService {
    @Value("\${application.domain}")
    lateinit var domain: String

    @Value("\${application.frontend}")
    lateinit var frontendURL: String

    override fun sendPasswordReset(email: String) {
        val token = PasswordResetToken.generate(email)
        repository.saveToken(token)

        val resetLink = "https://$frontendURL/reset-password?token=${token.token}"


        val context = Context().apply {
            setVariable("resetLink", resetLink)
            setVariable("domain", domain)
        }
        val htmlContent = templateEngine.process("reset_password", context)
        val message: MimeMessage = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, true, "UTF-8")
        helper.setFrom("no-reply@$domain")
        helper.setTo(email)
        helper.setSubject("🔐 Password Reset Request")
        helper.setText(htmlContent, true)

        mailSender.send(message)
    }
    override fun getEmailFromToken(token: String): String {
        val email = repository.findByToken(token)
        repository.delete("token:$token")
        return email
    }

}