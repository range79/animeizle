package com.range.rangeWatch.user.domain.repository

import com.range.rangeWatch.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
    fun existsByEmailOrUsername(username: String, email: String): Boolean
    fun existsUserByEmail(email: String): Boolean
    fun existsUserByUsername(username: String): Boolean
    fun findByEmail(email: String): Optional<User>
    fun findByUsername(username: String): Optional<User>
    @Query("select * from users where username = :username and deleted =true", nativeQuery = true)
    fun findDeletedUserByUsername(username: String): Optional<User>
    @Query("select * from users where email =:email and deleted=true", nativeQuery = true)
    fun findDeletedUserByEmail(email: String): Optional<User>
    }