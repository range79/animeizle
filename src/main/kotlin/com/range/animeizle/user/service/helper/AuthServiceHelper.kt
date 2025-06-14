package com.range.animeizle.user.service.helper

import com.range.animeizle.user.dao.model.User
import com.range.animeizle.user.dao.repository.UserRepository
import com.range.animeizle.user.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class AuthServiceHelper(private val userRepository: UserRepository) {
    fun isEmail(input: String): Boolean {
        return input.contains("@") && input.contains(".")
    }

    fun findUserByUsernameOrEmail(input: String): User? {
        return if (isEmail(input)) {
            userRepository.findByEmail(input)
        } else {
            userRepository.findByUsername(input)
        }?:throw UserNotFoundException("User not found")
    }





}