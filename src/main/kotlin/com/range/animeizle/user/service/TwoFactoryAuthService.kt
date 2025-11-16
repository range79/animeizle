package com.range.animeizle.user.service

import com.range.animeizle.user.dto.request.TwoFactoryAuthRequest
import com.range.animeizle.user.dto.response.AuthResponse

interface TwoFactoryAuthService {
    fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse
}