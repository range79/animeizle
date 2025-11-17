package com.range.animeWatch.user.service

import com.range.animeWatch.user.dto.request.ResetPasswordRequest
import com.range.animeWatch.user.dto.response.AuthResponse

interface PasswordService {
    fun forgotPassword(email: String)
    fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse
}