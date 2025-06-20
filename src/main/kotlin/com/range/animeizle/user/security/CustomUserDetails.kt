package com.range.animeizle.user.security

import com.range.animeizle.user.domain.entity.Role
import com.range.animeizle.user.domain.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(private val user: User) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority?> {
        return mutableListOf(user.role ?: Role.ROLE_USER)
    }

    override fun getPassword(): String {
        return user.password ?: ""
    }


    override fun getUsername(): String {
        return user.username ?: ""
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}