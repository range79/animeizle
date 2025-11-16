package com.range.animeizle.user.service.impl

import com.range.animeizle.common.service.EmailService
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.service.UserAccountService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(
    private val userRepository: UserRepository,
) : UserAccountService {


    override fun activateUser(email: String) {
        val user = userRepository.findDeletedUserByEmail(email).orElseThrow { UsernameNotFoundException("User not found") }
        user.deleted = false
        userRepository.save(user)

    }

    override fun frozeAccount(email: String) {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

    private fun isEmail(usernameOrEmail: String): Boolean {
        return usernameOrEmail.contains("@") && usernameOrEmail.contains(".")
    }
}