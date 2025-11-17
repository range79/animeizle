package com.range.rangeWatch.user.dto.response

data class AuthResponse(
    val refreshToken: String,
    val accessToken: String
)