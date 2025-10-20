package com.range.userservice.dto

class ResetPasswordRequest (
    val token: String,
    val newPassword: String
)