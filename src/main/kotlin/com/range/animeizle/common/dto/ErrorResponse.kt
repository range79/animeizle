package com.range.animeizle.common.dto

data class ErrorResponse (
    val errorCode: Int,
    val errorMessage: String,
    val timestamp: Long
)