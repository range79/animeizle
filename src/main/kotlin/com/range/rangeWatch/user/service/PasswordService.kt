package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.dto.request.ForgotPasswordRequest
import com.range.rangeWatch.user.dto.request.ResetPasswordRequest
import com.range.rangeWatch.user.dto.response.AuthResponse

interface PasswordService {
    fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest)
    fun resetPassword(token: String, resetPasswordRequest: ResetPasswordRequest): AuthResponse
}