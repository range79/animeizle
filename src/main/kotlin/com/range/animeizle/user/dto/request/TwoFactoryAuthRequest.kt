package com.range.animeizle.user.dto.request

data class TwoFactoryAuthRequest (
    val email: String,
    val code: Int

)