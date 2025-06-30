package com.range.animeizle.common

import com.range.animeizle.user.security.CustomUserDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class CustomSecurityContext {

     fun getUserId(): Long{
        return (SecurityContextHolder.getContext().authentication.principal as CustomUserDetails).getId()
    }


}