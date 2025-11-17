package com.range.animeWatch.user.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate

data class RegisterRequest (
    @param:Email
    val email: String,
    @field:NotEmpty
    val username: String,
    @field:NotEmpty
    val password: String,
    @field:NotEmpty
    val birthday: LocalDate
)