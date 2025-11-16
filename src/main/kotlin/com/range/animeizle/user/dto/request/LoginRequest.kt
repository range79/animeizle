package com.range.animeizle.user.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class LoginRequest(
    @field:NotEmpty
    val usernameOrEmail: String,
    @field:NotEmpty
    @Size(min = 8, max = 255)
    val password: String,
)
