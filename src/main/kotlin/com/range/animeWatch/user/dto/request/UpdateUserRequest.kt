package com.range.animeWatch.user.dto.request

data class UpdateUserRequest (
    var username: String,
    var email: String,
    var twoFactorEnabled: Boolean = false,
)