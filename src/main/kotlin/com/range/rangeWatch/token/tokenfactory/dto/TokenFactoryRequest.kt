package com.range.rangeWatch.token.tokenfactory.dto

import com.range.rangeWatch.user.domain.enums.Role
import java.util.UUID

data class TokenFactoryRequest (
    val userId: UUID,
    val role: Role?
)