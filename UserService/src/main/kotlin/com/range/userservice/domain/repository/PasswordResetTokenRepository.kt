package com.range.userservice.domain.repository

import com.range.userservice.domain.entity.PasswordResetToken

interface PasswordResetTokenRepository {
    fun saveToken(token: PasswordResetToken)
    fun findByToken(token: String): String
    fun delete(token: String)
    fun exitsByEmail(email: String): Boolean
}