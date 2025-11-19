package com.range.rangeWatch.user.controller

import com.range.rangeWatch.user.api.TwoFactorAuthApi
import com.range.rangeWatch.user.dto.request.TwoFactoryAuthRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import com.range.rangeWatch.user.service.TwoFactoryAuthService
import org.springframework.web.bind.annotation.RestController

@RestController
class TwoFactoryAuthController (
    private val twoFactoryAuthService: TwoFactoryAuthService,
): TwoFactorAuthApi {
    override fun activateTwoFactor() {
        return twoFactoryAuthService.activateTwoFactory()
    }

    override fun deactivateTwoFactor() {
        return twoFactoryAuthService.deactivateTwoFactory()
    }

    override fun verifyTwoFactor(request: TwoFactoryAuthRequest): AuthResponse {
        return twoFactoryAuthService.twoFactorAuth(request)
    }
}