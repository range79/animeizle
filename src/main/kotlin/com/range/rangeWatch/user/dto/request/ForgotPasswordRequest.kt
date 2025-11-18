package com.range.rangeWatch.user.dto.request

import jakarta.validation.constraints.Email

data class ForgotPasswordRequest (
    @field:Email(message = "Must be a valid email address")
    val email: String,
)