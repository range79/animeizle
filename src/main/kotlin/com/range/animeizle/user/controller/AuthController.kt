package com.range.animeizle.user.controller

import com.range.animeizle.user.api.AuthApi
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.RegisterResponse
import com.range.animeizle.user.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val authService: AuthService): AuthApi {
    override fun login(loginRequest: LoginRequest): ResponseEntity<String> {
        return ResponseEntity.ok(authService.login(loginRequest =loginRequest))
    }

    override fun register(registerRequest: RegisterRequest): ResponseEntity<String> {
       return ResponseEntity.ok(authService.register(registerRequest))
    }
}
