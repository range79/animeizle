package com.range.animeWatch.user.dto.response

import com.range.animeWatch.user.domain.enums.Role
import java.util.UUID

data class RegisterResponse(
    val userId: UUID,
    val role: Role,
)