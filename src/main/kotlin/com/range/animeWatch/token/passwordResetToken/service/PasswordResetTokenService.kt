package com.range.animeWatch.token.passwordResetToken.service

interface PasswordResetTokenService {
    fun generateToken(email:String): String
    fun getEmailFromToken(token:String): String
}