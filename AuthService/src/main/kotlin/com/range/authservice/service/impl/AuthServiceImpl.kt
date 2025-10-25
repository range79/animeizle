package com.range.authservice.service.impl

import com.range.authservice.domain.entity.Role
import com.range.authservice.dto.LoginRequest
import com.range.authservice.dto.LoginResponse
import com.range.authservice.service.AuthService
import com.range.authservice.service.TokenService
import com.range.authservice.service.UserServiceClient
import com.range.authservice.util.JwtUtil
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthServiceImpl(
    private val jwtUtil: JwtUtil,
    private val tokenService: TokenService,
    private val userServiceClient: UserServiceClient,
) : AuthService {
    override fun login(loginRequest: LoginRequest): LoginResponse {
        val service = userServiceClient.verifyUser(loginRequest)
        return loginResponse(service.userId, service.roles)
    }

    override fun logout(tokenId: String) {
        return tokenService.deleteToken(tokenId)
    }

    override fun refresh(tokenId: String): LoginResponse {
        val tokenEntity = tokenService.findToken(tokenId)
        val userId = tokenEntity.userId
        val roles = userServiceClient.getRoles(tokenEntity.userId)
        tokenService.deleteToken(tokenId)
        return loginResponse(userId, roles)
    }

    fun loginResponse(userId: UUID, role: Set<Role>): LoginResponse {
        val accessToken = jwtUtil.generateToken(userId, role)
        val refreshToken = tokenService.generateToken(userId)
        return LoginResponse(accessToken = accessToken, refreshToken = refreshToken)
    }
}