package com.range.rangeWatch.user.domain.repository

import com.range.rangeWatch.user.domain.entity.UserProfile
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface UserProfileRepository : JpaRepository<UserProfile, UUID>{
    fun findByUserUsername(userUsername: String): Optional<UserProfile>
}