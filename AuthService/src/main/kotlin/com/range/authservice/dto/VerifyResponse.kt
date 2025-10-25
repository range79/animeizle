package com.range.authservice.dto

import com.range.authservice.domain.entity.Role
import java.util.UUID

data class VerifyResponse (
    val userId: UUID,
    val roles: Set<Role>,
)