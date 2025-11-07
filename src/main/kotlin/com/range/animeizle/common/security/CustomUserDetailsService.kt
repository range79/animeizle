package com.range.animeizle.common.security

import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

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