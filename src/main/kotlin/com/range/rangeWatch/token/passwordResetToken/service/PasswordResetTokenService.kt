package com.range.rangeWatch.token.passwordResetToken.service

interface PasswordResetTokenService {
    fun generateToken(email:String): String
    fun getEmailFromToken(token:String): String
}