package com.range.animeizle.user.dto

import java.time.LocalDate

data class RegisterRequest (
    val email: String,
    val username: String,
    val password: String,
    val birthday: LocalDate
)