package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.user.exception.AccountDeletedException
import com.range.rangeWatch.user.exception.AuthenticationException
import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.user.domain.enums.Role
import com.range.rangeWatch.user.domain.repository.UserRepository
import com.range.rangeWatch.user.dto.request.LoginRequest
import com.range.rangeWatch.user.dto.response.LoginResponse
import com.range.rangeWatch.user.service.AuthLoginService
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
            role= user.role,
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