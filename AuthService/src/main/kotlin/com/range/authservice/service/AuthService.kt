package com.range.authservice.service

import com.range.authservice.dto.LoginRequest
import com.range.authservice.dto.LoginResponse

interface AuthService {
    fun login(loginRequest: LoginRequest): LoginResponse
    fun logout()

}
