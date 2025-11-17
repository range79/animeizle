package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.common.service.EmailService
import com.range.rangeWatch.token.passwordResetToken.service.PasswordResetTokenService
import com.range.rangeWatch.token.tokenfactory.dto.TokenFactoryRequest
import com.range.rangeWatch.token.tokenfactory.service.TokenFactoryService
import com.range.rangeWatch.token.twoFactoryAuth.service.TwoFactoryAuthTokenService
import com.range.rangeWatch.user.domain.repository.UserRepository
import com.range.rangeWatch.user.dto.request.LoginRequest
import com.range.rangeWatch.user.dto.request.RegisterRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import com.range.rangeWatch.user.service.AuthLoginService
import com.range.rangeWatch.user.service.AuthRegisterService
import com.range.rangeWatch.user.service.AuthService
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