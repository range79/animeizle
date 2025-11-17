package com.range.animeWatch.token.tokenfactory.service

import com.range.animeWatch.token.tokenfactory.dto.TokenFactoryRequest
import com.range.animeWatch.user.dto.response.AuthResponse

interface TokenFactoryService {

    fun createTokens(tokenFactoryRequest: TokenFactoryRequest): AuthResponse
    fun logout()

}