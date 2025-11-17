package com.range.animeWatch.common.util.impl

import com.range.animeWatch.common.exception.UserNotFoundException
import com.range.animeWatch.common.util.SecurityContextUtil
import com.range.animeWatch.user.domain.entity.User
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class SecurityContextUtilImpl: SecurityContextUtil {

   override fun getCurrentUserId(): UUID {
        val principal = SecurityContextHolder.getContext().authentication?.principal
        if (principal is User) {
            return principal.id!!
        } else {
            throw UserNotFoundException("User not found")
        }
    }
}