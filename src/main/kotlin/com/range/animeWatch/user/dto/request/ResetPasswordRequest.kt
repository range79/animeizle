package com.range.animeWatch.user.dto.request

import jakarta.validation.constraints.NotEmpty

data class ResetPasswordRequest(
    @field:NotEmpty
    val token: String,
    @field:NotEmpty
    val password: String,

    )