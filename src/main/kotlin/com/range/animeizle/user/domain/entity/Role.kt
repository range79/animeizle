package com.range.animeizle.user.domain.entity

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ADMIN,
    USER;

    override fun getAuthority(): String = name
}
