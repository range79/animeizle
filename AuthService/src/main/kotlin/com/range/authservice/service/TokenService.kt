package com.range.authservice.service


import com.range.authservice.domain.entity.TokenEntity
import java.util.*

interface TokenService {
    fun generateToken(userId: UUID): String
    fun deleteToken(tokenId: String)
    fun findToken(tokenId: String): TokenEntity
    fun checkToken(tokenId: String): Boolean
}