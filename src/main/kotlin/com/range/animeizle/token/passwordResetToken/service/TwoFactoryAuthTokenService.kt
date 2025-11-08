package com.range.animeizle.token.passwordResetToken.service

interface TwoFactoryAuthTokenService {
    fun generateToken(email:String): Int
    fun validateToken(email:String,code: Int): Boolean

}