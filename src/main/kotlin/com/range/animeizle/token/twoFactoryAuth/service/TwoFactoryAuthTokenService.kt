package com.range.animeizle.token.twoFactoryAuth.service

interface TwoFactoryAuthTokenService {
    fun generateToken(email:String): Int
    fun validateToken(email:String,code: Int): Boolean

}