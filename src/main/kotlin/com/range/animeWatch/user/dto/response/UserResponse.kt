package com.range.animeWatch.user.dto.response

import java.util.UUID

data class UserResponse(
    val id: UUID,
    val username: String,
)