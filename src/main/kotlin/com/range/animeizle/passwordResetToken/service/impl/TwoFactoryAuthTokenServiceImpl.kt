package com.range.animeizle.passwordResetToken.service.impl

import com.range.animeizle.passwordResetToken.domain.entity.TwoFactoryAuthToken
import com.range.animeizle.passwordResetToken.domain.repository.TwoFactoryAuthTokenRepository
import com.range.animeizle.passwordResetToken.exception.TwoFactoryAuthTokenNotFoundException
import com.range.animeizle.passwordResetToken.service.TwoFactoryAuthTokenService
import org.springframework.stereotype.Service

@Service
class TwoFactoryAuthTokenServiceImpl(
    private val twoFactoryAuthTokenRepository: TwoFactoryAuthTokenRepository
) : TwoFactoryAuthTokenService {
    override fun generateToken(email: String): Int {
        if (twoFactoryAuthTokenRepository.existsPasswordResetTokenByEmail(email)) {
            twoFactoryAuthTokenRepository.deleteByEmail(email)
        }
        val token = TwoFactoryAuthToken.createForUser(email)
        twoFactoryAuthTokenRepository.save(token)
        return token.code
    }
    override fun validateToken(email: String, code: Int): Boolean {
        val normalizedEmail = email.trim().lowercase()

        val token = twoFactoryAuthTokenRepository.findByEmail(normalizedEmail).orElse(null)
            ?: return false

        return token.code == code
    }
}



