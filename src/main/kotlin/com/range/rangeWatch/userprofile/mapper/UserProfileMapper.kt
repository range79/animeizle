package com.range.rangeWatch.userprofile.mapper

import com.range.rangeWatch.userprofile.domain.entity.UserProfile
import com.range.rangeWatch.userprofile.dto.response.UserProfileResponse
import org.springframework.stereotype.Component

@Component
class UserProfileMapper {
    fun toUserProfileResponse(entity: UserProfile): UserProfileResponse {
        return UserProfileResponse(
            id = entity.id,
            username = entity.user.username,
            gender = entity.gender,
            birthday = entity.birthDate,
            avatarUrl = entity.avatarUrl,
            bio = entity.bio
        )
    }
}