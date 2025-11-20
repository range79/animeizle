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
    @PostMapping("/logout")
    fun logout()
}
