package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.dto.request.ResetPasswordRequest
import com.range.rangeWatch.user.dto.response.AuthResponse

interface PasswordService {
    fun forgotPassword(email: String)
    fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse
}