package com.range.animeizle.user.dto

data class ResetPasswordRequest(
    val token: String,
    val password: String,

    )