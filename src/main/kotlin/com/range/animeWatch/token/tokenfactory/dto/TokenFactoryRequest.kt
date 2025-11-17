package com.range.animeWatch.token.tokenfactory.dto

import com.range.animeWatch.user.domain.enums.Role
import java.util.UUID

data class TokenFactoryRequest (
    val userId: UUID,
    val role: Role
)