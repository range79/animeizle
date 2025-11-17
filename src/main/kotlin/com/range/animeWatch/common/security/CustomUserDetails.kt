package com.range.animeWatch.common.security

import com.range.animeWatch.user.domain.enums.Role
import com.range.animeWatch.user.domain.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
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