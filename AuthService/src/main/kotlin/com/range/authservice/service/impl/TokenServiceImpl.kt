package com.range.authservice.service.impl

import com.range.authservice.domain.entity.TokenEntity
import com.range.authservice.domain.repository.AuthTokenRepository
import com.range.authservice.exception.TokenNotFoundException
import com.range.authservice.service.TokenService
import org.springframework.stereotype.Service
import java.util.*

@Service
class TokenServiceImpl(private val authTokenRepository: AuthTokenRepository) : TokenService {
    override fun generateToken(
        userId: UUID,
    ): String {
        val token =authTokenRepository.saveToken(TokenEntity.generate(userId))
        return token.tokenId
    }

    override fun deleteToken(tokenId: String) {
        authTokenRepository.deleteToken(tokenId)
    }


    override fun findToken(tokenId: String): TokenEntity {
     return authTokenRepository.getToken(tokenId)?:throw TokenNotFoundException("Token not found")
    }

    override fun checkToken(tokenId: String): Boolean {
        return authTokenRepository.exitsById(tokenId)
    }

}