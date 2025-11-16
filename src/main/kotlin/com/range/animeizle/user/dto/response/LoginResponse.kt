package com.range.animeizle.user.dto.response

import com.range.animeizle.user.domain.enums.Role
import java.util.UUID

data class LoginResponse(
    val userId: UUID,
    val email: String,
    val role: Role,
    val twoFactorRequired: Boolean
)