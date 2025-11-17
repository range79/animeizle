package com.range.animeWatch.user.service

import com.range.animeWatch.user.dto.request.LoginRequest
import com.range.animeWatch.user.dto.response.LoginResponse

interface AuthLoginService {
    fun login(request: LoginRequest): LoginResponse
}