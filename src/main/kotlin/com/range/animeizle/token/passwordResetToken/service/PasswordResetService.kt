package com.range.animeizle.token.passwordResetToken.service

interface PasswordResetService {
    fun generateToken(email:String): String
    fun getEmailFromToken(token:String): String
}