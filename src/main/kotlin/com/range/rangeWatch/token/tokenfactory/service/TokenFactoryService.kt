package com.range.rangeWatch.token.tokenfactory.service

import com.range.rangeWatch.token.tokenfactory.dto.TokenFactoryRequest
import com.range.rangeWatch.user.dto.response.AuthResponse

interface TokenFactoryService {

    fun createTokens(tokenFactoryRequest: TokenFactoryRequest): AuthResponse
    fun logout()

}