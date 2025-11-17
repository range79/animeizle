package com.range.rangeWatch.user.dto.request

data class UpdateUserRequest (
    var username: String,
    var email: String,
    var twoFactorEnabled: Boolean = false,
)