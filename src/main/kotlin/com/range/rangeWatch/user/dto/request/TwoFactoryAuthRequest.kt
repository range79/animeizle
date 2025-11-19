package com.range.rangeWatch.user.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class TwoFactoryAuthRequest (
    @field:Email(message = "Please enter a valid email")
    val email: String,
    @field:NotEmpty(message = "Please enter valid code")
    val code: Int
)