package com.range.animeizle.user.service.impl

import com.range.animeizle.common.util.JWTUtil
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.AuthResponse
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.ResetPasswordRequest
import com.range.animeizle.user.exception.EmailAlreadyUsedException
import com.range.animeizle.user.exception.UsernameAlreadyUsedException
import com.range.animeizle.user.service.AuthService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JWTUtil

) : AuthService {
    override fun register(registerRequest: RegisterRequest): AuthResponse {
        if (userRepository.existsUserByEmail(registerRequest.email)) {
            throw EmailAlreadyUsedException("${registerRequest.email} is already registered!")
        }
        if (userRepository.existsUserByUsername(registerRequest.username)) {
            throw UsernameAlreadyUsedException("${registerRequest.username} is already used!")
        }
        val password = passwordEncoder.encode(registerRequest.password)
        val user = User.generateUser(registerRequest, password)
        val refreshToken =jwtUtil.generateToken(user.id, user.role)
        val accessToken=null


    }

    override fun login(loginRequest: LoginRequest): AuthResponse {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(email: String) {
        TODO("Not yet implemented")
    }

    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse {
        TODO("Not yet implemented")
    }
}