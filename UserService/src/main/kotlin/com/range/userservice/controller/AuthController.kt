package com.range.userservice.controller

import com.range.userservice.dto.ForgotPasswordRequest
import com.range.userservice.dto.LoginRequest
import com.range.userservice.dto.RegisterRequest
import com.range.userservice.dto.ResetPasswordRequest
import com.range.userservice.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController (
    private val authService : AuthService
){
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest):String {
        return authService.login(loginRequest)
    }
    @PostMapping("/register")
    fun register(@RequestBody registerRequest: RegisterRequest): String{
        return authService.register(registerRequest)
    }
    @PostMapping("/logout")
    fun logout(){
        return authService.logout()
    }
    @PostMapping("/forgotPassword/")
    fun forgotPassword(@RequestBody forgotPasswordRequest: ForgotPasswordRequest):String {
        return authService.forgotPassword(forgotPasswordRequest)
    }
    @PostMapping("/resetPassword/")
    fun resetPassword(@RequestBody resetPasswordRequest: ResetPasswordRequest): String{
        return authService.resetPassword(resetPasswordRequest)
    }


}