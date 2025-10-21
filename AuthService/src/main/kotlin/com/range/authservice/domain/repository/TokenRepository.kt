package com.range.authservice.domain.repository

import com.range.authservice.domain.entity.TokenEntity

interface TokenRepository {
    fun saveToken(token: TokenEntity)
    fun getToken(): TokenEntity
    fun deleteToken(tokenId: String)
}