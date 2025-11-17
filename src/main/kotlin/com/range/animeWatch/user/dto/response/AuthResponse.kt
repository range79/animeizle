package com.range.animeWatch.user.dto.response

data class AuthResponse(
    val refreshToken: String,
    val accessToken: String
)