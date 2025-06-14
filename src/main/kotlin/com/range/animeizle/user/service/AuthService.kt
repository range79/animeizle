package com.range.animeizle.user.service

import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.RegisterResponse

interface AuthService {
    fun login(loginRequest: LoginRequest?): String
    fun register(registerRequest: RegisterRequest?): RegisterResponse
}