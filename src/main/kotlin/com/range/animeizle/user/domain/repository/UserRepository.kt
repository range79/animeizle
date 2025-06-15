package com.range.animeizle.user.domain.repository

import com.range.animeizle.user.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>{
    fun findByUsername(username: String): User?
    fun existsByUsername(username: String): Boolean
    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): User?
}