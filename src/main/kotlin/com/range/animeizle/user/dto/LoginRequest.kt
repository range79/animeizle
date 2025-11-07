package com.range.animeizle.user.dto

data class LoginRequest(
    val usernameOrEmail: String,
    val password: String,
)
