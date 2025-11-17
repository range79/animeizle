package com.range.rangeWatch.token.twoFactoryAuth.service

interface TwoFactoryAuthTokenService {
    fun generateToken(email:String): Int
    fun validateToken(email:String,code: Int): Boolean

}