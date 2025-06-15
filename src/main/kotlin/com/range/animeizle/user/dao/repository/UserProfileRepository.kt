package com.range.animeizle.user.dao.repository

import com.range.animeizle.user.dao.model.UserProfile
import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileRepository : JpaRepository<UserProfile?, Long?>
