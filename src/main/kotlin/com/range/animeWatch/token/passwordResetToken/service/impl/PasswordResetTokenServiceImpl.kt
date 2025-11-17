package com.range.animeWatch.token.passwordResetToken.service.impl

import com.range.animeWatch.token.passwordResetToken.domain.entity.PasswordResetToken
import com.range.animeWatch.token.passwordResetToken.domain.repository.PasswordResetTokenRepository
import com.range.animeWatch.token.passwordResetToken.exception.PasswordTokenIsNotValidException
import com.range.animeWatch.token.passwordResetToken.service.PasswordResetTokenService
import org.springframework.stereotype.Service

@Service
class PasswordResetTokenServiceImpl(
    private val passwordResetTokenRepository: PasswordResetTokenRepository
) : PasswordResetTokenService {

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
