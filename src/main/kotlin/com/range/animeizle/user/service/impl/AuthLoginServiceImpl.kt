package com.range.animeizle.user.service.impl

import com.range.animeizle.common.exception.AccountDeletedException
import com.range.animeizle.common.exception.AuthenticationException
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.request.LoginRequest
import com.range.animeizle.user.dto.response.LoginResponse
import com.range.animeizle.user.service.AuthLoginService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthLoginServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,

): AuthLoginService {
    override fun login(request: LoginRequest): LoginResponse {
        val identifier = request.usernameOrEmail
        val user = findActiveUser(identifier) ?: handleDeletedUser(identifier)
        if (!passwordEncoder.matches(request.password, user.password)) {
            throw AuthenticationException("Username or password invalid!")
        }
        return LoginResponse(
            userId = user.id,
            username = user.username,
            email = user.email,
            twoFactorRequired = user.twoFactorEnabled
        )

    }
    private fun findActiveUser(identifier: String): User? {
        return if (isEmail(identifier)) {
            userRepository.findByEmail(identifier).orElse(null)
        } else {
            userRepository.findByUsername(identifier).orElse(null)
        }
    }

    private fun handleDeletedUser(identifier: String): User {
        if (isEmail(identifier)) {
            userRepository.findDeletedUserByEmail(identifier)
        } else {
            userRepository.findDeletedUserByUsername(identifier)
        }.orElseThrow {
            AuthenticationException("Username or password invalid!")
        }

        throw AccountDeletedException("Account is deactivated!.")
    }


    private fun isEmail(usernameOrEmail: String): Boolean {
        return usernameOrEmail.contains("@") && usernameOrEmail.contains(".")
    }

}