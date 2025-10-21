package com.range.authservice.domain.entity

import java.security.SecureRandom
import java.time.Instant
import java.util.Base64
import java.util.UUID

data class TokenEntity(
    val tokenId: String,
    val userId: UUID,
    val createdAt: Instant,
    val expiresAt: Instant
) {
    companion object {
        fun generate(userId: UUID, validityDays: Long = 7): TokenEntity {
            val bytes = ByteArray(64)
            SecureRandom().nextBytes(bytes)
            val token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes)

            val now = Instant.now()
            val expires = now.plusSeconds(validityDays * 24 * 60 * 60)

            return TokenEntity(
                tokenId = token,
                userId = userId,
                createdAt = now,
                expiresAt = expires
            )
        }
    }

    fun isExpired(): Boolean = Instant.now().isAfter(expiresAt)
}