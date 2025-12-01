package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.user.exception.EmailAlreadyUsedException
import com.range.rangeWatch.user.exception.InvalidUsernameException
import com.range.rangeWatch.user.exception.UsernameAlreadyUsedException
import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.user.domain.enums.Role
import com.range.rangeWatch.user.domain.repository.UserRepository
import com.range.rangeWatch.user.dto.request.RegisterRequest
import com.range.rangeWatch.user.dto.response.RegisterResponse
import com.range.rangeWatch.user.service.AuthRegisterService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthRegisterServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : AuthRegisterService {
    override fun register(registerRequest: RegisterRequest): RegisterResponse {
        if (userRepository.existsUserByEmail(registerRequest.email)) {
            throw EmailAlreadyUsedException("${registerRequest.email} is already registered!")
        }
        if (userRepository.existsUserByUsername(registerRequest.username)) {
            throw UsernameAlreadyUsedException("${registerRequest.username} is already used!")
        }
        isValidUsername(registerRequest.username)
        val password = passwordEncoder.encode(registerRequest.password)!!
        val user = User.generateUser(registerRequest, password)
        return RegisterResponse(userId = user.id,role= Role.USER)

    }
    private fun isValidUsername(username: String): Boolean {
        if (username.contains("@") || username.contains(".")) {
            throw InvalidUsernameException("Username cannot contain '@' or '.'")
        }
        return true
    }
}