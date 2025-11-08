package com.range.animeizle.token.passwordResetToken.service.impl

import com.range.animeizle.token.passwordResetToken.domain.entity.PasswordResetToken
import com.range.animeizle.token.passwordResetToken.domain.repository.PasswordResetTokenRepository
import com.range.animeizle.token.passwordResetToken.exceptıon.PasswordTokenIsNotValidException
import com.range.animeizle.token.passwordResetToken.service.PasswordResetService
import org.springframework.stereotype.Service

@Service
class PasswordResetServiceImpl(
    private val passwordResetTokenRepository: PasswordResetTokenRepository
) : PasswordResetService {

    override fun generateToken(email: String): String {
        val normalizedEmail = email.trim().lowercase()

        if (passwordResetTokenRepository.existsByEmail(normalizedEmail)) {
            passwordResetTokenRepository.deleteByEmail(normalizedEmail)
        }

        val token = PasswordResetToken.createForUser(normalizedEmail)
        passwordResetTokenRepository.save(token)

        return token.id
    }

    override fun getEmailFromToken(token: String): String {
        val tokenEntity = passwordResetTokenRepository.findById(token)
            .orElseThrow { PasswordTokenIsNotValidException("Invalid or expired reset token") }

        return tokenEntity.email
    }
}
