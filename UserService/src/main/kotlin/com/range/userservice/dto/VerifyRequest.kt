package com.range.userservice.dto

import jakarta.validation.constraints.NotBlank

data class VerifyRequest (
    @field:NotBlank
    val username : String,
    @field:NotBlank
    val password: String
)