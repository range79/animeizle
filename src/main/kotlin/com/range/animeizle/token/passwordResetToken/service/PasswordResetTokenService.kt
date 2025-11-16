package com.range.animeizle.token.passwordResetToken.service

interface PasswordResetTokenService {
    fun generateToken(email:String): String
    fun getEmailFromToken(token:String): String
}