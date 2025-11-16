package com.range.animeizle.user.dto.request

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class TwoFactoryAuthRequest (
    @Email
    val email: String,
    @field:NotEmpty
    val code: Int

)