package com.range.animeizle.user.controller

import com.range.animeizle.user.api.AuthApi
import com.range.animeizle.user.dto.AuthResponse
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.ResetPasswordRequest
import com.range.animeizle.user.service.AuthService
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val authService: AuthService) : AuthApi{
    override fun register(registerRequest: RegisterRequest): AuthResponse {
        return authService.register(registerRequest)
    }

    override fun login(loginRequest: LoginRequest):AuthResponse {
        return authService.login(loginRequest)
    }

    override fun forgotPassword(email: String)  {
        return authService.forgotPassword(email)
    }

    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest):AuthResponse {
        return authService.resetPassword(resetPasswordRequest)
    }


}