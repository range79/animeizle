package com.range.commentservice.dto

data class ErrorResponse (
    val errorCode: Int,
    val errorMessage: String,
    val timestamp: Long
)