package com.range.authservice.dto

data class LoginResponse (
    val accessToken: String,
    val refreshToken: String
)