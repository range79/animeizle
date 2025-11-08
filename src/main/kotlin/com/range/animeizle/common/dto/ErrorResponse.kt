package com.range.animeizle.common.dto

import org.springframework.http.HttpStatus
import java.time.Instant

data class ErrorResponse (
    val message: String,
    val status: HttpStatus,
    val time: Instant = Instant.now(),
    val path:String? = null,
    val method: String? = null,
)