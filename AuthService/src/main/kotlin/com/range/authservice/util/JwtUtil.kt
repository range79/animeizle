package com.range.authservice.util

import com.range.authservice.domain.entity.Role
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.security.Key
import java.util.*
import javax.crypto.SecretKey


@Component
class JwtUtil {
private lateinit var secretKey: String

    fun generateToken(userId: UUID, roles: Set<Role>): String {
        val now = Date()
        val expiry = Date(now.time + 1000 * 60 * 60)

        return Jwts.builder()
            .subject(userId.toString())
            .claim("roles", roles.map { it.name })
            .issuedAt(now)
            .expiration(expiry)
            .signWith(getSigningKey())
            .compact()
    }

    private fun getSigningKey(): Key {
        val keyBytes = Decoders.BASE64.decode(secretKey)
        return Keys.hmacShaKeyFor(keyBytes)
    }
    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parser()
                .verifyWith(getSigningKey() as SecretKey)
                .build()
                .parseSignedClaims(token)
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun extractClaims(token: String): Map<String, Any> {
        val claims = Jwts.parser()
            .verifyWith(getSigningKey() as SecretKey)
            .build()
            .parseSignedClaims(token)
            .payload
        return claims
    }

    fun getRoles(token: String): List<Role> {
        val claims = extractClaims(token)
        val roleNames = claims["roles"] as List<*>
        return roleNames.map { Role.valueOf(it.toString()) }
    }

    fun getUserId(token: String): UUID {
        val claims = extractClaims(token)
        return UUID.fromString(claims["sub"].toString())
    }

}
