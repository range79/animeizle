package com.range.animeizle.token.service

import com.range.animeizle.token.domain.entity.RefreshToken

interface RefreshTokenService {
    fun findRefreshToken(token: String): String
    fun deleteRefreshToken(token: String,details: Boolean): String?
    fun saveRefreshToken(token: String): String
    fun checkRefreshToken(token: String): Boolean
}