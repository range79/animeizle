package com.range.userservice.dto

import org.springframework.http.HttpStatus
import java.time.Instant
import java.time.LocalDateTime

data class ErrorResponse (
    val status: HttpStatus,
    val message: String,
    val timestamp: Instant,
)