package com.range.rangeWatch.user.dto.request

import jakarta.validation.constraints.NotEmpty
import software.amazon.awssdk.annotations.NotNull

data class UpdateUserRequest (
    @field:NotEmpty
    var username: String,
    @field:NotEmpty
    var email: String,
    @field:NotEmpty
    var twoFactorEnabled: Boolean = false,
)