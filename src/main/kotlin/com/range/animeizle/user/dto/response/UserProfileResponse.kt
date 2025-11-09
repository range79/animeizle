package com.range.animeizle.user.dto.response

import com.range.animeizle.user.domain.entity.UserProfile
import com.range.animeizle.user.domain.enums.Gender
import io.lettuce.core.KillArgs.Builder.user
import java.time.LocalDate
import java.util.*

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
