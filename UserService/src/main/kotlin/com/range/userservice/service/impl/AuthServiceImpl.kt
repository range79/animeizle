package com.range.userservice.service.impl

import com.range.userservice.dto.ForgotPasswordRequest
import com.range.userservice.dto.LoginRequest
import com.range.userservice.dto.RegisterRequest
import com.range.userservice.dto.ResetPasswordRequest
import com.range.userservice.mapper.UserMapper
import com.range.userservice.service.AuthService
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    val userMapper: UserMapper
): AuthService {
    override fun login(loginRequest: LoginRequest): String {



    }

    override fun register(registerRequest: RegisterRequest): String {
        TODO("Not yet implemented")
    }

    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest): String {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): String {
        TODO("Not yet implemented")
    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}