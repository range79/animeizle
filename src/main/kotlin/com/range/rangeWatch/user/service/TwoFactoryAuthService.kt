package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.dto.request.TwoFactoryAuthRequest
import com.range.rangeWatch.user.dto.response.AuthResponse

interface TwoFactoryAuthService {
    fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse
}