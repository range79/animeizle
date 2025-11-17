package com.range.animeWatch.user.service

import com.range.animeWatch.user.dto.response.AuthResponse
import com.range.animeWatch.user.dto.request.LoginRequest
import com.range.animeWatch.user.dto.request.RegisterRequest

interface AuthService {
    fun register(registerRequest: RegisterRequest): AuthResponse
    fun login(loginRequest: LoginRequest): AuthResponse
    fun logoutFromDevice()
}
