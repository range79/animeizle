package com.range.authservice.domain.repository.impl

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.range.authservice.domain.entity.TokenEntity
import com.range.authservice.domain.repository.AuthTokenRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class AuthTokenRepositoryImpl(
    private val redisTemplate: RedisTemplate<String, String>
) : AuthTokenRepository {

    private val objectMapper = jacksonObjectMapper()

    override fun saveToken(token: TokenEntity): TokenEntity {
        val value = objectMapper.writeValueAsString(token)
        val ttl = token.expiresAt.epochSecond - token.createdAt.epochSecond
        redisTemplate.opsForValue().set("token:${token.tokenId}", value, ttl, java.util.concurrent.TimeUnit.SECONDS)
        return token
    }

    override fun getToken(tokenId: String): TokenEntity? {
        val value = redisTemplate.opsForValue().get("token:$tokenId") ?: return null
        return objectMapper.readValue(value)
    }

    override fun deleteToken(tokenId: String) {
        redisTemplate.delete("token:$tokenId")
    }

    override fun exitsById(tokenId: String): Boolean{
        val token= redisTemplate.opsForValue().get("token:$tokenId")
        return token != null
    }
}
