package com.range.rangeWatch.user.controller

import com.range.rangeWatch.user.api.AuthApi
import com.range.rangeWatch.user.dto.request.LoginRequest
import com.range.rangeWatch.user.dto.request.RegisterRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import com.range.rangeWatch.user.service.AuthService
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val authService: AuthService) : AuthApi {

    override fun register(registerRequest: RegisterRequest): AuthResponse {
        return authService.register(registerRequest)
    }

    override fun login(loginRequest: LoginRequest): AuthResponse {
        return authService.login(loginRequest)
    }

    override fun logout() {
        return authService.logoutFromDevice()
    }

//    override fun forgotPassword(email: String) {
//        authService.forgotPassword(email)
//    }
//
//    override fun resetPassword(resetPasswordRequest: ResetPasswordRequest): AuthResponse {
//        return authService.resetPassword(resetPasswordRequest)
//    }
//
//    override fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse {
//        return authService.twoFactorAuth(
//        twoFactoryAuthRequest
//        )
//    }
}
