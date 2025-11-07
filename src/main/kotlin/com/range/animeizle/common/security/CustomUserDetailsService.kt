package com.range.animeizle.common.security

import com.range.animeizle.user.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomUserDetailsService  (
    private val userRepository: UserRepository,
){
     fun loadUserById(id: UUID): UserDetails? {
         userRepository.findById(id).orElseThrow { UserNot }

    }

}