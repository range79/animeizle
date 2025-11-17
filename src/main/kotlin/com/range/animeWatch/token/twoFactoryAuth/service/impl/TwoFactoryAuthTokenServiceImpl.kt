package com.range.animeWatch.token.twoFactoryAuth.service.impl

import com.range.animeWatch.token.twoFactoryAuth.domain.entity.TwoFactoryAuthToken
import com.range.animeWatch.token.twoFactoryAuth.domain.repository.TwoFactoryAuthTokenRepository
import com.range.animeWatch.token.twoFactoryAuth.service.TwoFactoryAuthTokenService
import org.springframework.stereotype.Service

@Service
class TwoFactoryAuthTokenServiceImpl(
    private val twoFactoryAuthTokenRepository: TwoFactoryAuthTokenRepository
) : TwoFactoryAuthTokenService {
    override fun generateToken(email: String): Int {
        if (twoFactoryAuthTokenRepository.existsPasswordResetTokenByEmail(email)) {
            twoFactoryAuthTokenRepository.deleteByEmail(email)
        }
        val token = TwoFactoryAuthToken.Companion.createForUser(email)
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



