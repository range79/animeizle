package com.range.animeizle.user.service.impl

import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.service.UserAccountService
import org.springframework.stereotype.Service

@Service
class UserAccountServiceImpl(
    private val userRepository: UserRepository,
): UserAccountService {
    override fun sendActivationToUser(email: String) {


    }

    override fun activateUser(email: String) {
        TODO("Not yet implemented")
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