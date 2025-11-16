package com.range.animeizle.user.dto.request

import com.range.animeizle.user.domain.enums.Gender
import jakarta.validation.constraints.NotEmpty
import java.time.LocalDate

data class UserProfileRequest(
    var bio: String?=null,
    var gender: Gender? = null,
    @NotEmpty
    var birthDate: LocalDate? = null,
)