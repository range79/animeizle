package com.range.animeizle.token.service

import com.range.animeizle.token.domain.entity.RefreshToken
import com.range.animeizle.token.domain.repository.RefreshTokenRepository
import com.range.animeizle.token.exception.TokenNotFoundException
import org.springframework.stereotype.Service

@Service
class RefreshTokenServiceImpl(
    private val tokenRepository: RefreshTokenRepository,
):RefreshTokenService {
    override fun findRefreshToken(token: String): String {
        val token =findToken(token)

        return token.token

    }




    override fun deleteRefreshToken(token: String,details: Boolean): String? {
        val token = findToken(token)
            tokenRepository.delete(token)
        return if (details){
             token.token
        }else
        {
            null
        }

    }

    override fun saveRefreshToken(token: String): String {
TODO("l will refactor it but now lm so lazy for it")
    }

    override fun checkRefreshToken(token: String): Boolean {
        TODO("Not yet implemented")
    }
    private fun findToken(token: String): RefreshToken {
        return tokenRepository.findByToken(token)?:throw TokenNotFoundException("Token not found")
    }
}