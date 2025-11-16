package com.range.animeizle.user.dto.response

import com.range.animeizle.user.domain.entity.User

data class AuthResponse(
    val refreshToken: String,
    val accessToken: String
)