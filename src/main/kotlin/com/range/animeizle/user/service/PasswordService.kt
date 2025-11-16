package com.range.animeizle.user.service

import com.range.animeizle.user.dto.request.ResetPasswordRequest
import com.range.animeizle.user.dto.response.AuthResponse

interface PasswordService {
    fun forgotPassword(email: String)
    fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse
}