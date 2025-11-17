package com.range.rangeWatch.token.refreshToken.domain.entity

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.security.SecureRandom
import java.util.Base64
import java.util.UUID

@RedisHash("refreshToken")
data class RefreshToken(
    val id: String,
    val userId: UUID,
    val device: String,
    @TimeToLive
    val expiration: Long = 2_592_000L


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

        fun createForUser(userId: UUID, device: String): RefreshToken {

            return RefreshToken(
                id = generateToken(),
                userId = userId,
                device = device,
            )
        }
    }
}