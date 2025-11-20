package com.range.rangeWatch.userprofile.service

import com.range.rangeWatch.userprofile.domain.entity.UserProfile
import com.range.rangeWatch.userprofile.dto.response.UserProfileResponse

interface UserProfileQueryService {
    fun findByUsername(username: String): UserProfile
    fun me(): UserProfile
}