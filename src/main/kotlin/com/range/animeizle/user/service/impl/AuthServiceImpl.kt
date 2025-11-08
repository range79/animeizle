package com.range.animeizle.user.service.impl

import com.range.animeizle.common.util.JWTUtil
import com.range.animeizle.token.passwordResetToken.service.TwoFactoryAuthTokenService
import com.range.animeizle.token.refreshToken.service.RefreshTokenService
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.AuthResponse
import com.range.animeizle.user.dto.LoginRequest
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.ResetPasswordRequest
import com.range.animeizle.user.exception.AuthenticationException
import com.range.animeizle.user.exception.EmailAlreadyUsedException
import com.range.animeizle.user.exception.UsernameAlreadyUsedException
import com.range.animeizle.user.service.AuthService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtUtil: JWTUtil,
    private val refreshTokenService: RefreshTokenService,
    private val twoFactoryAuthTokenService: TwoFactoryAuthTokenService

) : AuthService {
    @Transactional
    override fun register(registerRequest: RegisterRequest): AuthResponse {
        if (userRepository.existsUserByEmail(registerRequest.email)) {
            throw EmailAlreadyUsedException("${registerRequest.email} is already registered!")
        }
        if (userRepository.existsUserByUsername(registerRequest.username)) {
            throw UsernameAlreadyUsedException("${registerRequest.username} is already used!")
        }
        val password = passwordEncoder.encode(registerRequest.password)
        val user = User.generateUser(registerRequest, password)
        val accessToken = jwtUtil.generateToken(user.id, user.role)
        val refreshToken = refreshTokenService.generateToken(user.id!!)
        return AuthResponse(refreshToken = refreshToken, accessToken = accessToken)

    }

    override fun login(loginRequest: LoginRequest): AuthResponse {
        var user: User
        if (isEmail(loginRequest.usernameOrEmail)) {
            user = userRepository.findByEmail(loginRequest.usernameOrEmail).orElseThrow {
                AuthenticationException("Username or password invalid!")
            }
        } else {
            user = userRepository.findByUsername(loginRequest.usernameOrEmail)
                .orElseThrow { AuthenticationException("Username or password invalid!") }
        }
        if (!passwordEncoder.matches(loginRequest.password, user.password)) {
            throw AuthenticationException("Username or password invalid!")
        }
//todo add 2 fa verification

        val accessToken = jwtUtil.generateToken(user.id, user.role)
        val refreshToken = refreshTokenService.generateToken(user.id!!)
        return AuthResponse(refreshToken = refreshToken, accessToken = accessToken)
    }

    override fun forgotPassword(email: String) {

    }

    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse {
        TODO("Not yet implemented")
    }

    private fun isEmail(usernameOrEmail: String): Boolean {
        TODO()
    }
}