package com.range.animeWatch.token.tokenfactory.service.impl

import com.range.animeWatch.common.util.DeviceInfoHolder
import com.range.animeWatch.common.util.JWTUtil
import com.range.animeWatch.common.util.SecurityContextUtil
import com.range.animeWatch.token.refreshToken.service.RefreshTokenService
import com.range.animeWatch.token.tokenfactory.dto.TokenFactoryRequest
import com.range.animeWatch.token.tokenfactory.service.TokenFactoryService
import com.range.animeWatch.user.dto.response.AuthResponse
import org.springframework.stereotype.Service

@Service
class TokenFactoryServiceImpl(
    private val jwtUtil: JWTUtil,
    private val refreshTokenService: RefreshTokenService,
    private val securityContextUtil: SecurityContextUtil
): TokenFactoryService {
    override fun createTokens(request: TokenFactoryRequest): AuthResponse {
        val refreshToken = refreshTokenService.generateToken(request.userId)
        val accessToken = jwtUtil.generateToken(request.userId,request.role)
        return AuthResponse(refreshToken=refreshToken, accessToken=accessToken)

    }

    override fun logout() {
        val device = DeviceInfoHolder.getContext()
        return refreshTokenService.deleteTokenByUserIdAndDeviceId(securityContextUtil.getCurrentUserId(), device.deviceName)
    }
}