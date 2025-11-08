package com.range.animeizle.user.service

import com.range.animeizle.user.dto.response.AuthResponse
import com.range.animeizle.user.dto.request.LoginRequest
import com.range.animeizle.user.dto.request.RegisterRequest
import com.range.animeizle.user.dto.request.ResetPasswordRequest
import com.range.animeizle.user.dto.request.TwoFactoryAuthRequest

interface AuthService {
    fun register(registerRequest: RegisterRequest): AuthResponse
    fun login(loginRequest: LoginRequest): AuthResponse
    fun forgotPassword(email: String)
    fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse
    fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse
}
