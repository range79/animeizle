package com.range.animeizle.user.dto.request

data class UpdateUserRequest (
    var username: String,
    var password: String,
    var email: String,
    var twoFactorEnabled: Boolean = false,
)