package com.range.animeizle.user.dto

data class RegisterRequest (
    var username: String,
    val email: String,
    val password: String
)