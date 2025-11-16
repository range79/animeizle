package com.range.animeizle.user.service

import com.range.animeizle.user.dto.request.LoginRequest
import com.range.animeizle.user.dto.response.LoginResponse

interface AuthLoginService {
    fun login(request: LoginRequest): LoginResponse
}