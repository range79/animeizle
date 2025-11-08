package com.range.animeizle.user.api

import com.range.animeizle.user.dto.response.AuthResponse
import com.range.animeizle.user.dto.request.LoginRequest
import com.range.animeizle.user.dto.request.RegisterRequest
import com.range.animeizle.user.dto.request.ResetPasswordRequest
import com.range.animeizle.user.dto.request.TwoFactoryAuthRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping("\${api.prefix}/auth")
interface AuthApi
{
    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): AuthResponse

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): AuthResponse

    @PostMapping("/forgot-password")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun forgotPassword(@RequestParam email: String)

    @PostMapping("/reset-password")
    fun resetPassword(@RequestBody resetPasswordRequest: ResetPasswordRequest): AuthResponse

    @PostMapping("/two-factor-auth")
    fun twoFactorAuth(@RequestBody twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse
}