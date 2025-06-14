package com.range.animeizle.common.util

import com.range.animeizle.user.dao.model.Role
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey


@Component
class JwtUtil {
    @Value("\${jwt.secret}")
    private lateinit var secret: String
    @Value("\${jwt.duration}")
    private lateinit var duration: String
    fun generateToken(username: String?, role: Role): String? {
        return Jwts
            .builder().subject(username)
            .claim("role", role.authority).signWith(getSecretKey())
            .expiration(Date(System.currentTimeMillis() + duration.toLong() * 1000L))
            .compact()
    }

    fun getSecretKey(): SecretKey {
        return Keys
            .hmacShaKeyFor(
                secret
                    .toByteArray()
            )
    }

    fun parseToken(token: String?): Claims {
        return Jwts
            .parser()
            .verifyWith(getSecretKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
    }

    fun getUsername(token: String?): String {
        val claims = parseToken(token)
        return claims.getSubject()
    }

    fun validateToken(token: String?, userDetails: UserDetails): Boolean {
        val claim = parseToken(token)

        val username = claim.getSubject()


        val expiration = claim.getExpiration()

        val expired = expiration.before(Date())

        return username == userDetails.getUsername() && !expired
    }


}