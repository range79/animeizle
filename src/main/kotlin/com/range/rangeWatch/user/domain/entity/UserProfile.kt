package com.range.rangeWatch.user.domain.entity

import com.range.rangeWatch.user.domain.enums.Gender
import com.range.rangeWatch.user.dto.request.UserProfileRequest
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.MapsId
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDate
import java.util.UUID
@Table(name = "user_profile")
@Entity
data class UserProfile(
    @Id
    val id: UUID,

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    var user: User,
    var bio: String?,

    var gender: Gender?=null,
    var birthDate: LocalDate? = null,
    var avatarUrl: String?
){
    companion object
    {
        fun create(user: User,profileRequest: UserProfileRequest): UserProfile{
            return UserProfile(
                user.id,
                bio = profileRequest.bio,
                gender = profileRequest.gender,
                birthDate = profileRequest.birthDate,
                user = user,
                avatarUrl = null
            )
        }



        fun update(userProfile: UserProfile,profileRequest: UserProfileRequest): UserProfile{
            return UserProfile(
                id = userProfile.id,
                bio=profileRequest.bio,
                gender = profileRequest.gender,
                birthDate = profileRequest.birthDate,
                user = userProfile.user,
                avatarUrl = userProfile.avatarUrl
            )
        }
    }
}