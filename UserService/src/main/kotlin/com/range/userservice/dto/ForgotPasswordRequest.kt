package com.range.userservice.dto

import jakarta.validation.constraints.Email


data class ForgotPasswordRequest (
    @field:Email
    val email: String,
)