package com.range.userservice.service

interface PasswordTokenService {
    fun sendPasswordReset(email: String)
    fun getEmailFromToken(token: String): String
}