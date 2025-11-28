package com.range.rangeWatch.userprofile.dto.request

import com.range.rangeWatch.user.domain.enums.Gender
import java.time.LocalDate

data class UpdateUserProfileRequest (
    var bio: String?,
    var gender: Gender? = null,
    var birthDate: LocalDate? = null,
)