package com.range.rangeWatch.user.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size
import java.time.LocalDate

data class RegisterRequest (
    @param:Email
    @field:NotEmpty(message = "Please enter an email")
    val email: String,

    @field:NotEmpty(message = "Please enter a Username")
    val username: String,
    @field:NotEmpty(message = "Please enter a Password")
    @field:Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
    val password: String,
    @field:NotEmpty(message = "Please enter a birthday")
    val birthday: LocalDate
)