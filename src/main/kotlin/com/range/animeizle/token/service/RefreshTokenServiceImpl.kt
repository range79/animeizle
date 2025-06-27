package com.range.animeizle.token.service

import com.range.animeizle.token.domain.entity.RefreshToken
import com.range.animeizle.token.domain.repository.RefreshTokenRepository
import com.range.animeizle.token.exception.TokenNotFoundException
import org.springframework.stereotype.Service

@Service
class RefreshTokenServiceImpl(
    private val tokenRepository: RefreshTokenRepository,
):RefreshTokenService {
    override fun findRefreshToken(token: String): RefreshToken? {
       val token = tokenRepository.findByToken(token)
            ?:throw TokenNotFoundException("Token not found")


        TODO()



    }

    override fun deleteRefreshToken(token: String) {
        TODO("Not yet implemented")
    }

    override fun saveRefreshToken(token: String): RefreshToken {
        TODO("Not yet implemented")
    }

    override fun checkRefreshToken(token: String): Boolean {
        TODO("Not yet implemented")
    }
}