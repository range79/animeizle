package com.range.rangeWatch.user.api

import com.range.rangeWatch.user.dto.request.LoginRequest
import com.range.rangeWatch.user.dto.request.RegisterRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import org.springframework.web.bind.annotation.*

@RequestMapping("\${api.prefix}/auth")
interface AuthApi {

    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): AuthResponse

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): AuthResponse
//
//    @PostMapping("/forgot-password")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    fun forgotPassword(@RequestParam("email") email: String)
//
//    @PostMapping("/reset-password")
//    fun resetPassword(@RequestBody resetPasswordRequest: ResetPasswordRequest): AuthResponse
//
//    @PostMapping("/two-factor-auth")
//    fun twoFactorAuth(@RequestBody twoFactorAuthRequest: TwoFactoryAuthRequest): AuthResponse
}
