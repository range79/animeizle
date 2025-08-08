package com.range.animeizle.user.domain.repository

import com.range.animeizle.user.domain.entity.UserProfile

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserProfileRepository : JpaRepository<UserProfile, Long>{
    fun findByUsername(username: String): Optional<UserProfile>
}
