package com.range.authservice.domain.repository

import com.range.authservice.domain.entity.TokenEntity
import java.util.UUID

interface AuthTokenRepository {
    fun saveToken(token: TokenEntity): TokenEntity
    fun getToken(tokenId: String): TokenEntity?
    fun deleteToken(tokenId: String)
    fun exitsById(tokenId: String): Boolean
}