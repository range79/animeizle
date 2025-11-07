package com.range.animeizle.user.domain.repository

import com.range.animeizle.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
    fun existsEmailOrUsername(username: String,email: String): Boolean
    fun existsUserByEmail(email: String): Boolean
    fun existsUserByUsername(username: String): Boolean
    fun findByEmail(email: String): Optional<User>
    fun findByUsername(username: String): Optional<User>
}