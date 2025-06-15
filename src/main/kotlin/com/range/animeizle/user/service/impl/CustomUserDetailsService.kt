package com.range.animeizle.user.service.impl

import com.range.animeizle.user.dao.repository.UserRepository
import com.range.animeizle.user.security.CustomUserDetails
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {


    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        if (username.isEmpty()) {
            throw UsernameNotFoundException("Username is empty")

        }

        val user =  userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("User not found")
        return CustomUserDetails(user)
    }
}
