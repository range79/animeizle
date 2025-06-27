package com.range.animeizle.token.service

import com.range.animeizle.token.domain.entity.RefreshToken

interface RefreshTokenService {
    fun findRefreshToken(token: String): RefreshToken?
    fun deleteRefreshToken(token: String)
    fun saveRefreshToken(token: String): RefreshToken
    fun checkRefreshToken(token: String): Boolean
}