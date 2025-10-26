package com.range.userservice.controller

import com.range.userservice.domain.entity.Role
import com.range.userservice.dto.*
import com.range.userservice.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("\${api.prefix}")
@RestController
class UserController(
    private val userService: UserService
) {
    @PostMapping("/verify")
    fun verifyUser(@RequestBody request: VerifyRequest): VerifyResponse {
        return userService.verifyUser(request)
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    fun register(@RequestBody @Valid registerRequest: RegisterRequest) {
        return userService.register(registerRequest)
    }

    @PostMapping("/forgot-Password")
    fun forgotPassword(@RequestBody @Valid forgotPasswordRequest: ForgotPasswordRequest) {
        return userService.forgotPassword(forgotPasswordRequest)
    }

    @PostMapping("/resetPassword")
    fun resetPassword(@RequestBody @Valid resetPasswordRequest: ResetPasswordRequest) {
        return userService.resetPassword(resetPasswordRequest)
    }

    @GetMapping("/{userid}/roles")
    fun getUserRoles(@PathVariable userid: UUID): Set<Role> {
        return userService.getRoles(userid)
    }
    @GetMapping("/{userid}")
    fun userExits(@PathVariable userid: UUID): Boolean {
        return userService.exitsByUserId(userid)
    }
}