package com.range.rangeWatch.user.service.impl

import com.range.rangeWatch.common.exception.AuthenticationException
import com.range.rangeWatch.common.exception.TwoFactoryAuthException
import com.range.rangeWatch.common.util.SecurityContextUtil
import com.range.rangeWatch.token.tokenfactory.dto.TokenFactoryRequest
import com.range.rangeWatch.token.tokenfactory.service.TokenFactoryService
import com.range.rangeWatch.token.twoFactoryAuth.service.TwoFactoryAuthTokenService
import com.range.rangeWatch.user.domain.repository.UserRepository
import com.range.rangeWatch.user.dto.request.TwoFactoryAuthRequest
import com.range.rangeWatch.user.dto.request.UpdateUserRequest
import com.range.rangeWatch.user.dto.response.AuthResponse
import com.range.rangeWatch.user.service.TwoFactoryAuthService
import com.range.rangeWatch.user.service.UserCommandService
import com.range.rangeWatch.user.service.UserQueryService
import org.springframework.stereotype.Service

@Service
class TwoFactoryAuthServiceImpl(
    val userRepository: UserRepository,
    val twoFactoryAuthTokenService: TwoFactoryAuthTokenService,
    val tokenFactoryService: TokenFactoryService,
    private val userCommandService: UserCommandService,
    private val userQueryService: UserQueryService,
) : TwoFactoryAuthService {
    override fun activateTwoFactory() {
        val user = userQueryService.me()
        user.twoFactorEnabled = true
        val updatedUser = UpdateUserRequest(
            username = user.username,
            email = user.email,
            twoFactorEnabled = true,
        )
        userCommandService.updateUser(user.id, updatedUser)

    }

    override fun deactivateTwoFactory() {
        TODO("Not yet implemented")
    }

    override fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse {
        if (!twoFactoryAuthTokenService.validateToken(twoFactoryAuthRequest.email, twoFactoryAuthRequest.code)) {
            throw TwoFactoryAuthException("Two Factor Authentication Failed!")
        }
        val user = userRepository.findByEmail(twoFactoryAuthRequest.email).orElseThrow {
            AuthenticationException("User doesn't exist!")
        }
        val token = TokenFactoryRequest(user.id, user.role)
        return tokenFactoryService.createTokens(token)
    }

}