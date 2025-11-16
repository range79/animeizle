package com.range.animeizle.user.service.impl

import com.range.animeizle.common.exception.EmailNotFoundException
import com.range.animeizle.common.service.EmailService
import com.range.animeizle.token.passwordResetToken.service.PasswordResetTokenService
import com.range.animeizle.token.tokenfactory.dto.TokenFactoryRequest
import com.range.animeizle.token.tokenfactory.service.TokenFactoryService
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.request.ResetPasswordRequest
import com.range.animeizle.user.dto.response.AuthResponse
import com.range.animeizle.user.service.PasswordService
import com.range.animeizle.user.service.UserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
@Service
class PasswordServiceImpl(
    private val passwordResetTokenService: PasswordResetTokenService,
    private val emailService: EmailService,
    private val userRepository: UserRepository,
    private val tokenFactoryService: TokenFactoryService,
    private val passwordEncoder: PasswordEncoder,
    private val userService: UserService
): PasswordService {

    override fun forgotPassword(email: String) {
        val token = passwordResetTokenService.generateToken(email)
        emailService.sendPasswordResetEmail(email, token)
    }

    @Transactional
    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse {
        val email = passwordResetTokenService.getEmailFromToken(resetPasswordRequest.token)
     userService.update(email,)
        userRepository.save(user)
        return tokenFactoryService.createTokens(TokenFactoryRequest(user.id,user.role))
    }



}