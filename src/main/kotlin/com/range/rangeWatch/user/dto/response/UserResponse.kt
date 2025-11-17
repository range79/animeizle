package com.range.rangeWatch.user.dto.response

import java.util.UUID

data class UserResponse(
    val id: UUID,
    val username: String,
)