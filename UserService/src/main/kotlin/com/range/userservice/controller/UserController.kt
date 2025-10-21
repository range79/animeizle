package com.range.userservice.controller

import com.range.userservice.domain.entity.Role
import com.range.userservice.dto.ForgotPasswordRequest
import com.range.userservice.dto.RegisterRequest
import com.range.userservice.dto.ResetPasswordRequest
import com.range.userservice.dto.VerifyRequest
import com.range.userservice.service.UserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class UserController (
    private val userService : UserService
){
    @PostMapping("/verify")
    fun verifyUser(@RequestBody request: VerifyRequest){
        return userService.verifyUser(request)
    }

    @PostMapping("/register")
    fun register(@RequestBody @Valid registerRequest: RegisterRequest){
        return userService.register(registerRequest)
    }

    @PostMapping("/forgotPassword")
    fun forgotPassword(@RequestBody @Valid forgotPasswordRequest: ForgotPasswordRequest) {
        return userService.forgotPassword(forgotPasswordRequest)
    }
    @PostMapping("/resetPassword")
    fun resetPassword(@RequestBody @Valid resetPasswordRequest: ResetPasswordRequest){
        return userService.resetPassword(resetPasswordRequest)
    }
    @GetMapping("/{userid}/roles")
    fun getUserRoles(@PathVariable userid: UUID):Set<Role>{
        return userService.getRoles(userid)
    }
}