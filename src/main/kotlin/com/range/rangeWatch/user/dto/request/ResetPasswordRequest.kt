package com.range.rangeWatch.user.dto.request

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class ResetPasswordRequest(
    @field:NotEmpty(message = "Please enter new password")
    @field:Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
    val password: String
)