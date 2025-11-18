package com.range.rangeWatch.user.api

import com.range.rangeWatch.user.dto.request.ForgotPasswordRequest
import com.range.rangeWatch.user.dto.request.ResetPasswordRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("\${api.prefix}/password")
interface PasswordApi {

    @PostMapping("/forgot-password")
    fun forgotPassword(@RequestBody request: ForgotPasswordRequest)

    @PostMapping("/reset-password/{token}")
    fun resetPassword(
        @PathVariable token: String,
        @RequestBody resetPasswordRequest: ResetPasswordRequest
    ): AuthResponse
}
