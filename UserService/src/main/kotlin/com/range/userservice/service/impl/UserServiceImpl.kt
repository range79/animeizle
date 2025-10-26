package com.range.userservice.service.impl

import com.range.userservice.domain.entity.Role
import com.range.userservice.domain.entity.User
import com.range.userservice.domain.repository.UserRepository
import com.range.userservice.dto.ForgotPasswordRequest
import com.range.userservice.dto.RegisterRequest
import com.range.userservice.dto.ResetPasswordRequest
import com.range.userservice.dto.VerifyRequest
import com.range.userservice.dto.VerifyResponse
import com.range.userservice.exception.AuthenticationException
import com.range.userservice.exception.EmailNotFoundException
import com.range.userservice.exception.UserNotFoundException
import com.range.userservice.service.UserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val passwordTokenService: PasswordTokenService,
) : UserService {

    @Transactional()
    override fun register(registerRequest: RegisterRequest) {
        val user = registerRequest.toModel(passwordEncoder.encode(registerRequest.password))
        userRepository.save(user)
    }

    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest) {
        val email = passwordTokenService.getEmailFromToken(resetPasswordRequest.token)
        val user = userRepository.findByEmail(email).orElseThrow {
            EmailNotFoundException("Email not found")
        }
        user.password = passwordEncoder.encode(resetPasswordRequest.newPassword)
        userRepository.save(user)
    }

    override fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest) {
        return passwordTokenService.sendPasswordReset(forgotPasswordRequest.email)
    }

    override fun getRoles(userId: UUID): Set<Role> {
        val user = userRepository.findById(userId).orElseThrow {
            UserNotFoundException("User not Found")
        }
        return user.role
    }

    override fun verifyUser(verifyRequest: VerifyRequest): VerifyResponse {
        val user = userRepository.findByEmail(verifyRequest.username)
            .orElseThrow { AuthenticationException("Username or password does not match required password") }
        if (!passwordEncoder.matches(verifyRequest.password, user.password)) {
            throw AuthenticationException("Username or password does not match required password")
        }
        return VerifyResponse(user.id!!, user.role)

    }

    override fun exitsByUserId(userid: UUID): Boolean {
        return userRepository.existsById(userid)
    }

    fun RegisterRequest.toModel(password: String): User {
        return User(
            id = null, email = email,
            username = username,
            password = password,
            emailVerified = false,
            role = setOf(Role.ROLE_USER),
            twoFactorEnabled = false,
        )
    }
}