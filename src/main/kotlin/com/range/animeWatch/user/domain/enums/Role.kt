package com.range.animeWatch.user.domain.enums

import org.springframework.security.core.GrantedAuthority

enum class Role : GrantedAuthority {
    ADMIN,
    USER;

    override fun getAuthority(): String = name
}