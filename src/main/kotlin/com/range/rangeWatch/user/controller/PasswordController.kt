package com.range.rangeWatch.user.controller

import com.range.rangeWatch.user.api.PasswordApi
import com.range.rangeWatch.user.dto.request.ForgotPasswordRequest
import com.range.rangeWatch.user.dto.request.ResetPasswordRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import com.range.rangeWatch.user.service.PasswordService
import org.springframework.web.bind.annotation.RestController

@RestController
class PasswordController(
    private val passwordService: PasswordService
) : PasswordApi {


    override fun forgotPassword(request: ForgotPasswordRequest) {
        return passwordService.forgotPassword(request)
    }

    override fun resetPassword(
        token: String,
        resetPasswordRequest: ResetPasswordRequest
    ): AuthResponse {
        return passwordService.resetPassword(token, resetPasswordRequest)
    }
}