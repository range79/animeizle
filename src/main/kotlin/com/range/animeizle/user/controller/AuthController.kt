package com.range.animeizle.user.controller

import com.range.animeizle.user.api.AuthApi
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.service.AuthService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseCookie
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val authService: AuthService): AuthApi {
    @Value("\${jwt.duration}")
    private var jwtDuration: Int = 0

    @Value("\${https.enable}")
    private var httpEnable: Boolean = false

    override fun login(loginRequest: LoginRequest): ResponseEntity<String> {


        val token = authService.login(loginRequest)

        val cookie = ResponseCookie.from("jwt", token)
            .httpOnly(true)
            .secure(httpEnable)
            .path("/")
            .maxAge(jwtDuration.toLong())
            .sameSite("Strict")
            .build()

        return ResponseEntity.ok()
            .header("Set-Cookie", cookie.toString())
            .body("Login successful")
    }

    override fun register(registerRequest: RegisterRequest): ResponseEntity<String> {
        val token = authService.register(registerRequest)

        val cookie = ResponseCookie.from("jwt", token)
            .httpOnly(true)
            .secure(httpEnable)
            .path("/")
            .maxAge(jwtDuration.toLong())
            .sameSite("Strict")
            .build()

        return ResponseEntity.ok()
            .header("Set-Cookie", cookie.toString())
            .body("Login successful")
    }
    }

