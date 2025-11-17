package com.range.rangeWatch.user.dto.response

import com.range.rangeWatch.user.domain.enums.Role
import java.util.UUID

data class LoginResponse(
    val userId: UUID,
    val email: String,
    val role: Role,
    val twoFactorRequired: Boolean
)