package com.range.userservice.dto

import com.range.userservice.domain.entity.Role
import java.util.UUID

data class VerifyResponse (
    val userId: UUID,
    val roles: Set<Role>,
)
