package com.range.animeizle.user.dto.response

import com.range.animeizle.user.domain.enums.Role
import java.util.UUID

data class RegisterResponse(
    val userId: UUID,
    val role: Role,
)