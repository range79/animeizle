package com.range.animeizle.user.dto.response

data class AuthResponse(
    val refreshToken: String,
    val accessToken: String
)