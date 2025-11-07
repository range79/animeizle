package com.range.animeizle.user.api

import com.range.animeizle.user.dto.AuthResponse
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.ResetPasswordRequest
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("\${api.prefix}/auth")
interface AuthApi
{
    fun register(registerRequest: RegisterRequest):AuthResponse
    fun login(loginRequest: LoginRequest):AuthResponse
    fun forgotPassword(email:String)
    fun resetPassword(resetPasswordRequest: ResetPasswordRequest):AuthResponse

}