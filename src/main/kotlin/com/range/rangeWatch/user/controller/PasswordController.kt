package com.range.rangeWatch.user.controller

import com.range.rangeWatch.user.api.PasswordApi
import com.range.rangeWatch.user.dto.request.ResetPasswordRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import com.range.rangeWatch.user.service.PasswordService
import org.springframework.web.bind.annotation.RestController

@RestController
class PasswordController(
    private val passwordService: PasswordService
): PasswordApi {
    override fun forgotPassword(email: String) {
        return passwordService.forgotPassword(email)
    }

    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse {
        return passwordService.resetPassword(resetPasswordRequest)
    }
}