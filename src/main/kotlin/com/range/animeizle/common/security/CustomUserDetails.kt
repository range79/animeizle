package com.range.animeizle.common.security

import com.range.animeizle.user.domain.enums.Role
import com.range.animeizle.user.domain.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import java.util.UUID

class CustomUserDetails (
    val user: User
): UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority?>{
        return mutableListOf(user.role?: Role.USER)
    }

    override fun getPassword(): String {
     return user.password
    }

    override fun getUsername(): String {
        return user.username
    }
    fun getId(): UUID {
        return user.id!!
    }

}