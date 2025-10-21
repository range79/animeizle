package com.range.userservice.dto

import jakarta.validation.constraints.NotBlank

class ResetPasswordRequest (
    @field:NotBlank
    val token: String,
    @field:NotBlank
    val newPassword: String
)