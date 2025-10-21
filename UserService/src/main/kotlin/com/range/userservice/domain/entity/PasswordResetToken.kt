package com.range.userservice.domain.entity

import java.security.SecureRandom
import java.util.Base64
import java.util.UUID

data class PasswordResetToken (
    val token: String,
    val email: String,
){
    companion object {
        fun generate(email: String): PasswordResetToken {
            val bytes = ByteArray(32)
            SecureRandom().nextBytes(bytes)
            val token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes)
            return PasswordResetToken(token, email)
        }
    }
}