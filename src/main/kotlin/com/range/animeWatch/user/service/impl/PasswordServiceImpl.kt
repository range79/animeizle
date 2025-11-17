package com.range.animeWatch.user.service.impl

import com.range.animeWatch.common.service.EmailService
import com.range.animeWatch.token.passwordResetToken.service.PasswordResetTokenService
import com.range.animeWatch.token.tokenfactory.dto.TokenFactoryRequest
import com.range.animeWatch.token.tokenfactory.service.TokenFactoryService
import com.range.animeWatch.user.dto.request.ResetPasswordRequest
import com.range.animeWatch.user.dto.response.AuthResponse
import com.range.animeWatch.user.service.PasswordService
import com.range.animeWatch.user.service.UserService
import org.springframework.stereotype.Service

@Service
class PasswordServiceImpl(
    private val passwordResetTokenService: PasswordResetTokenService,
    private val emailService: EmailService,
    private val tokenFactoryService: TokenFactoryService,
    private val userService: UserService
) : PasswordService {

    override fun forgotPassword(email: String) {
        val token = passwordResetTokenService.generateToken(email)
        emailService.sendPasswordResetEmail(email, token)
    }

    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse {
        val email = passwordResetTokenService.getEmailFromToken(resetPasswordRequest.token)
        val user = userService.getUserWithEmail(email)

        userService.updateUserPassword(user.id, resetPasswordRequest.password)


        return tokenFactoryService.createTokens(TokenFactoryRequest(user.id, user.role))
    }


}