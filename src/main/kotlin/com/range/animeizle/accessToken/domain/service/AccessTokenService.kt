package com.range.animeizle.accessToken.domain.service

import java.util.UUID

interface AccessTokenService {
    fun generateToken(userId: UUID): String
    fun deleteToken(token: String)
    fun rotateToken(token: String): String
    fun deleteTokenByUserIdAndDeviceId(userId: UUID, device: String)
}