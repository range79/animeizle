package com.range.userservice.service

import com.range.userservice.domain.entity.Role
import com.range.userservice.dto.ForgotPasswordRequest
import com.range.userservice.dto.RegisterRequest
import com.range.userservice.dto.ResetPasswordRequest
import com.range.userservice.dto.VerifyRequest
import com.range.userservice.dto.VerifyResponse
import java.util.UUID

interface UserService {
    fun register(registerRequest: RegisterRequest)
    fun resetPassword(resetPasswordRequest: ResetPasswordRequest)
    fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest)
    fun getRoles(userId: UUID): Set<Role>
    fun verifyUser(verifyRequest: VerifyRequest): VerifyResponse
}
