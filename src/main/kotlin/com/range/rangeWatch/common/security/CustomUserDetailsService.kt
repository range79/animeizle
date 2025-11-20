package com.range.rangeWatch.common.security

import com.range.rangeWatch.user.exception.UserNotFoundException
import com.range.rangeWatch.user.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository,
) {
    fun loadUserById(id: UUID): UserDetails {
        val user = userRepository.findById(id)
            .orElseThrow { UserNotFoundException("User not found") }
        return CustomUserDetails(user)
    }

}