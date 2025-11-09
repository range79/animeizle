package com.range.animeizle.user.dto.request

import com.range.animeizle.user.domain.enums.Gender
import java.time.LocalDate

data class UserProfileRequest(
    var bio: String?=null,
    var gender: Gender? = null,
    var birthDate: LocalDate? = null,
)