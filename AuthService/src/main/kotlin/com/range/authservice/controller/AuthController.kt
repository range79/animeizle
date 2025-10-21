package com.range.authservice.controller

import com.range.authservice.dto.LoginRequest
import com.range.authservice.dto.LoginResponse
import com.range.authservice.service.AuthService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val authService: AuthService
) {
    @PostMapping("/login")
    fun login(@RequestBody @Valid request: LoginRequest): LoginResponse {
        return authService.login(request)
    }

    @PostMapping("/logout")
    fun logout() {
        authService.logout()
    }
}
