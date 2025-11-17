package com.range.rangeWatch.user.dto.response

import com.range.rangeWatch.user.domain.enums.Role
import java.util.UUID

data class RegisterResponse(
    val userId: UUID,
    val role: Role,
)