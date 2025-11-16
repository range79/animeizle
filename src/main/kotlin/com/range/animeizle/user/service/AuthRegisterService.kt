package com.range.animeizle.user.service

import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.dto.request.RegisterRequest
import com.range.animeizle.user.dto.response.RegisterResponse

interface AuthRegisterService {
    fun register(registerRequest: RegisterRequest): RegisterResponse
}