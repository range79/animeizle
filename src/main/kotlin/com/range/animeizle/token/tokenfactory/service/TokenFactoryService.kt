package com.range.animeizle.token.tokenfactory.service

import com.range.animeizle.token.tokenfactory.dto.TokenFactoryRequest
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.dto.response.AuthResponse

interface TokenFactoryService {

    fun createTokens(tokenFactoryRequest: TokenFactoryRequest): AuthResponse
    fun logout()

}