package com.range.userservice.domain.repository.impl

import com.range.userservice.domain.entity.PasswordResetToken
import com.range.userservice.domain.repository.PasswordResetTokenRepository
import com.range.userservice.exception.PasswordResetTokenException
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.util.concurrent.TimeUnit
@Repository

class PasswordResetTokenRepositoryImpl(
    private val redisTemplate: RedisTemplate<String, String>
) : PasswordResetTokenRepository {
    override fun saveToken(token: PasswordResetToken) {
        return redisTemplate.opsForValue().set("token:${token.token}", token.email, 10, TimeUnit.MINUTES)
    }

    override fun findByToken(token: String): String {
        return redisTemplate.opsForValue().get("token:${token}")
            ?: throw PasswordResetTokenException("Token is Invalid")
    }

    override fun delete(token: String) {
        redisTemplate.delete(token)
    }

    override fun exitsByEmail(email: String): Boolean {
        return redisTemplate.opsForValue().get("email:${email}") != null
    }
}