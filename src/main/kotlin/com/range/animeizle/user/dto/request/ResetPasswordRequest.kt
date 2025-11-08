package com.range.animeizle.user.dto.request

data class ResetPasswordRequest(
    val token: String,
    val password: String,

    )