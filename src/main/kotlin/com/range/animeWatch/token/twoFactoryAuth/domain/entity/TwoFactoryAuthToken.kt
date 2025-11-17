package com.range.animeWatch.token.twoFactoryAuth.domain.entity

import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import java.security.SecureRandom
import java.util.UUID

@RedisHash("twoFactoryAuth")
data class TwoFactoryAuthToken(
    val id: UUID = UUID.randomUUID(),
    val code: Int,
    val email: String,
    val device: String? = null,
    @TimeToLive
    val expiration: Long = 900
) {
    companion object {
        private val secureRandom = SecureRandom()

        fun generateCode(): Int {
            return secureRandom.nextInt(900000) + 100000
        }

        fun createForUser(email: String, device: String? = null): TwoFactoryAuthToken {
            return TwoFactoryAuthToken(
                code = generateCode(),
                email = email,
                device = device
            )
        }
    }
}
