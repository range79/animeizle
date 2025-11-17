package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.dto.request.RegisterRequest
import com.range.rangeWatch.user.dto.response.RegisterResponse

interface AuthRegisterService {
    fun register(registerRequest: RegisterRequest): RegisterResponse
}