package com.range.userprofileservice.domain.repository

import com.range.userprofileservice.domain.entity.UserProfile
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserProfileRepository: JpaRepository<UserProfile, UUID> {
}