package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.dto.request.TwoFactoryAuthRequest
import com.range.rangeWatch.user.dto.response.AuthResponse

interface TwoFactoryAuthService {
    fun activateTwoFactory()
    fun deactivateTwoFactory()
    fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse

}