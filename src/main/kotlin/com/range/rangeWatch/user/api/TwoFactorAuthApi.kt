package com.range.rangeWatch.user.api

import com.range.rangeWatch.user.dto.request.TwoFactoryAuthRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("\${api.prefix}/2fa")
interface TwoFactorAuthApi {

    @PostMapping("/activate")
    fun activateTwoFactor()

    @PostMapping("/deactivate")
    fun deactivateTwoFactor()

    @PostMapping("/verify")
    fun verifyTwoFactor(
        @RequestBody request: TwoFactoryAuthRequest
    ): AuthResponse
}
