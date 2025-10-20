package com.range.userservice.service

import com.range.userservice.dto.ForgotPasswordRequest
import com.range.userservice.dto.LoginRequest
import com.range.userservice.dto.RegisterRequest
import com.range.userservice.dto.ResetPasswordRequest

interface AuthService {
  fun login(loginRequest: LoginRequest): String
  fun register(registerRequest: RegisterRequest): String
  fun resetPassword(resetPasswordRequest: ResetPasswordRequest): String
  fun forgotPassword(forgotPasswordRequest: ForgotPasswordRequest): String
  fun logout()
}
