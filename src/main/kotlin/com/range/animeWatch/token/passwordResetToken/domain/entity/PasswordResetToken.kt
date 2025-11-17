package com.range.animeWatch.token.passwordResetToken.domain.entity

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.security.SecureRandom
import java.util.Base64

@RedisHash("PasswordResetToken")
data class PasswordResetToken(
    val id: String,
    val email: String,
    @TimeToLive
    val expiration: Long = 900


) {
    companion object {
        private val secureRandom = SecureRandom()
        private val urlEncoder: Base64.Encoder = Base64.getUrlEncoder().withoutPadding()
        private const val DEFAULT_BYTE_LENGTH = 32

        fun generateToken(): String {
            val randomBytes = ByteArray(DEFAULT_BYTE_LENGTH)
            secureRandom.nextBytes(randomBytes)
            return urlEncoder.encodeToString(randomBytes)
        }

        fun createForUser(email: String,): PasswordResetToken {
            return PasswordResetToken(
                id = generateToken(),
                email = email,
            )
        }
    }
}