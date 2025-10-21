package com.range.authservice.domain.repository.impl

import com.range.authservice.domain.entity.TokenEntity
import com.range.authservice.domain.repository.TokenRepository
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class  TokenRepositoryImpl(
    private val redisTemplate: RedisTemplate<String, String>
): TokenRepository {
    override fun saveToken(token: TokenEntity) {
        TODO("Not yet implemented")
    }

    override fun getToken(): TokenEntity {
        TODO("Not yet implemented")
    }

    override fun deleteToken(tokenId: String) {
        TODO("Not yet implemented")
    }
}