package com.range.animeizle.token.tokenfactory.dto

import com.range.animeizle.user.domain.enums.Role
import java.util.UUID

data class TokenFactoryRequest (
    val userId: UUID,
    val role: Role
)