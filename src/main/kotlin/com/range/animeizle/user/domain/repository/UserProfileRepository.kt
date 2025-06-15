package com.range.animeizle.user.domain.repository

import com.range.animeizle.user.domain.model.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileRepository : JpaRepository<UserProfile?, Long?>
