package com.range.animeizle.user.service.impl

import com.range.animeizle.common.service.EmailService
import com.range.animeizle.token.passwordResetToken.service.PasswordResetTokenService
import com.range.animeizle.token.tokenfactory.dto.TokenFactoryRequest
import com.range.animeizle.token.tokenfactory.service.TokenFactoryService
import com.range.animeizle.token.twoFactoryAuth.service.TwoFactoryAuthTokenService
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.request.LoginRequest
import com.range.animeizle.user.dto.request.RegisterRequest
import com.range.animeizle.user.dto.response.AuthResponse
import com.range.animeizle.user.service.AuthLoginService
import com.range.animeizle.user.service.AuthRegisterService
import com.range.animeizle.user.service.AuthService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val tokenFactoryService: TokenFactoryService,
    private val twoFactoryAuthTokenService: TwoFactoryAuthTokenService,
    private val passwordResetService: PasswordResetTokenService,
    private val emailService: EmailService,
    private val authLoginService: AuthLoginService,
    private val authRegisterService: AuthRegisterService,

    ) : AuthService {
    @Transactional
    override fun register(registerRequest: RegisterRequest): AuthResponse {
       val user = authRegisterService.register(registerRequest)
        return tokenFactoryService.createTokens(TokenFactoryRequest(user.userId, user.role))
    }


    override fun login(loginRequest: LoginRequest): AuthResponse {
        val user = authLoginService.login(loginRequest)
        return tokenFactoryService.createTokens(TokenFactoryRequest(user.userId,user.role))
    }



    override fun logoutFromDevice() {
        return tokenFactoryService.logout()
    }

}