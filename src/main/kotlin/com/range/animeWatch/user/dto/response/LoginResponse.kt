package com.range.animeWatch.user.dto.response

import com.range.animeWatch.user.domain.enums.Role
import java.util.UUID

data class LoginResponse(
    val userId: UUID,
    val email: String,
    val role: Role,
    val twoFactorRequired: Boolean
)