package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.dto.request.LoginRequest
import com.range.rangeWatch.user.dto.response.LoginResponse

interface AuthLoginService {
    fun login(request: LoginRequest): LoginResponse
}