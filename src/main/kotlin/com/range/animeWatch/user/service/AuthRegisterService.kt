package com.range.animeWatch.user.service

import com.range.animeWatch.user.dto.request.RegisterRequest
import com.range.animeWatch.user.dto.response.RegisterResponse

interface AuthRegisterService {
    fun register(registerRequest: RegisterRequest): RegisterResponse
}