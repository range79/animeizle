package com.range.rangeWatch.userprofile.dto.response

import com.range.rangeWatch.user.domain.enums.Gender
import com.range.rangeWatch.userprofile.domain.entity.UserProfile
import java.time.LocalDate
import java.util.UUID

data class UserProfileResponse(
    var id: UUID?,
    var username: String?,
    var gender: Gender?,
    var birthday: LocalDate?,
    var avatarUrl: String?,
    var bio: String?
) {
    companion object {
        fun fromEntity(entity: UserProfile): UserProfileResponse {
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
}