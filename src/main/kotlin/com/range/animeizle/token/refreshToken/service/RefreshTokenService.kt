package com.range.animeizle.token.refreshToken.service

import java.util.UUID

interface RefreshTokenService {
    fun generateToken(userId: UUID): String
    fun deleteToken(token: String)
    fun rotateToken(token: String): String
    fun deleteTokenByUserIdAndDeviceId(userId: UUID, device: String)
    fun deletedAllUserTokens(userId: UUID)
}