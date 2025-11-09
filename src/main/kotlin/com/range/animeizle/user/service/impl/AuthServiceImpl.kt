package com.range.animeizle.user.service.impl

import com.range.animeizle.common.exception.*
import com.range.animeizle.common.service.EmailService
import com.range.animeizle.common.util.JWTUtil
import com.range.animeizle.token.passwordResetToken.service.PasswordResetService
import com.range.animeizle.token.refreshToken.service.RefreshTokenService
import com.range.animeizle.token.twoFactoryAuth.service.TwoFactoryAuthTokenService
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.response.AuthResponse
import com.range.animeizle.user.dto.request.LoginRequest
import com.range.animeizle.user.dto.request.RegisterRequest
import com.range.animeizle.user.dto.request.ResetPasswordRequest
import com.range.animeizle.user.dto.request.TwoFactoryAuthRequest
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
    private val twoFactoryAuthTokenService: TwoFactoryAuthTokenService,
    private val passwordResetService: PasswordResetService,
    private val emailService: EmailService

) : AuthService {
    @Transactional
    override fun register(registerRequest: RegisterRequest): AuthResponse {
        if (userRepository.existsUserByEmail(registerRequest.email)) {
            throw EmailAlreadyUsedException("${registerRequest.email} is already registered!")
        }
        if (userRepository.existsUserByUsername(registerRequest.username)) {
            throw UsernameAlreadyUsedException("${registerRequest.username} is already used!")
        }
        isValidUsername(registerRequest.username)
        val password = passwordEncoder.encode(registerRequest.password)
        val user = User.generateUser(registerRequest, password)
        return authResponseBuilder(user)

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
        if (user.twoFactorEnabled) {
           val token = twoFactoryAuthTokenService.generateToken(email = user.email)
            emailService.sendTwoFactorCode(user.email, token)
            throw TwoFactoryAuthException("Two Factor Enabled! Check Your Email!")
        }

        return authResponseBuilder(user)
    }

    override fun forgotPassword(email: String) {
        val token = passwordResetService.generateToken(email)
        emailService.sendPasswordResetEmail(email,token)
    }

    @Transactional
    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse {
        val email = passwordResetService.getEmailFromToken(resetPasswordRequest.token)
        val user = userRepository.findByEmail(email).orElseThrow {
            EmailNotFoundException("Email doesn't exist!")
        }
        user.password = passwordEncoder.encode(resetPasswordRequest.password)
        userRepository.save(user)
        return authResponseBuilder(user)
    }

    override fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest) : AuthResponse{
        if ( !twoFactoryAuthTokenService.validateToken(twoFactoryAuthRequest.email,twoFactoryAuthRequest.code)){
            throw TwoFactoryAuthException("Two Factor Authentication Failed!")
        }
        val user = userRepository.findByEmail(twoFactoryAuthRequest.email).orElseThrow{
            AuthenticationException("User doesn't exist!")
        }
        return authResponseBuilder(user)
    }

    private fun isEmail(usernameOrEmail: String): Boolean {
        return usernameOrEmail.contains("@") && usernameOrEmail.contains(".")
    }
    private fun isValidUsername(username: String): Boolean {
        if (username.contains("@") || username.contains(".")) {
            throw InvalidUsernameException("Username cannot contain '@' or '.'")
        }
        return true
    }

    fun authResponseBuilder(user: User): AuthResponse {
        val accessToken = jwtUtil.generateToken(user.id, user.role)
        val refreshToken = refreshTokenService.generateToken(user.id)
        return AuthResponse(refreshToken = refreshToken, accessToken = accessToken)
    }
}