package com.range.authservice.service.impl

import com.range.authservice.dto.LoginRequest
import com.range.authservice.dto.LoginResponse
import com.range.authservice.service.AuthService
import com.range.authservice.util.JwtUtil
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val jwtUtil: JwtUtil
): AuthService {
    override fun login(loginRequest: LoginRequest): LoginResponse {

    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}