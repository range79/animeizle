package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.dto.response.AuthResponse
import com.range.rangeWatch.user.dto.request.LoginRequest
import com.range.rangeWatch.user.dto.request.RegisterRequest

interface AuthService {
    fun register(registerRequest: RegisterRequest): AuthResponse
    fun login(loginRequest: LoginRequest): AuthResponse
    fun logoutFromDevice()
}
