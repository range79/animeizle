package com.range.animeizle.user.api

import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.RegisterResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping


@RequestMapping("/v1")
interface AuthApi {
    @PostMapping
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<String>
    fun register(@RequestBody registerRequest: RegisterRequest?): ResponseEntity<RegisterResponse>
}