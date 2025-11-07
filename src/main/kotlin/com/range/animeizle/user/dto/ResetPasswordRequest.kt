package com.range.animeizle.user.dto

data class ResetPasswordRequest(
    val email: String,
    val code: String,
    val password: String,

    )