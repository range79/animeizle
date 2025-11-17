package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.common.service.EmailService
import com.range.rangeWatch.token.passwordResetToken.service.PasswordResetTokenService
import com.range.rangeWatch.token.tokenfactory.dto.TokenFactoryRequest
import com.range.rangeWatch.token.tokenfactory.service.TokenFactoryService
import com.range.rangeWatch.user.dto.request.ResetPasswordRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import com.range.rangeWatch.user.service.PasswordService
import com.range.rangeWatch.user.service.UserService
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