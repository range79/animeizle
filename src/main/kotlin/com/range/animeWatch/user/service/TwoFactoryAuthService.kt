package com.range.animeWatch.user.service

import com.range.animeWatch.user.dto.request.TwoFactoryAuthRequest
import com.range.animeWatch.user.dto.response.AuthResponse

interface TwoFactoryAuthService {
    fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse
}