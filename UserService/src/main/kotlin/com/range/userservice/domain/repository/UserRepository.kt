package com.range.userservice.domain.repository

import com.range.userservice.domain.entity.Role
import com.range.userservice.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface UserRepository: JpaRepository<User, UUID> {
    fun findByUsername(username: String): Optional<User>
    fun findByEmail(email: String): Optional<User>
    fun role(role: MutableSet<Role>): MutableList<User>
}