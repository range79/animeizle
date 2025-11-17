package com.range.rangeWatch.user.dto.request

import com.range.rangeWatch.user.domain.enums.Gender
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate

data class UserProfileRequest(
    var bio: String?=null,
    var gender: Gender? = null,
    @NotEmpty
    var birthDate: LocalDate? = null,
)