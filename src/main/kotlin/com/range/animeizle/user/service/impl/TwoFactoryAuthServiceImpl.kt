package com.range.animeizle.user.service.impl

import com.range.animeizle.common.exception.AuthenticationException
import com.range.animeizle.common.exception.TwoFactoryAuthException
import com.range.animeizle.token.tokenfactory.service.TokenFactoryService
import com.range.animeizle.token.twoFactoryAuth.service.TwoFactoryAuthTokenService
import com.range.animeizle.user.domain.repository.UserRepository
import com.range.animeizle.user.dto.request.TwoFactoryAuthRequest
import com.range.animeizle.user.dto.response.AuthResponse
import com.range.animeizle.user.service.AuthService
import com.range.animeizle.user.service.TwoFactoryAuthService
import com.range.animeizle.user.service.UserService
import org.springframework.stereotype.Service

@Service
class TwoFactoryAuthServiceImpl(
    val userRepository: UserRepository,
    val twoFactoryAuthTokenService: TwoFactoryAuthTokenService,
   val  tokenFactoryService: TokenFactoryService,
) : TwoFactoryAuthService {

    override fun twoFactorAuth(twoFactoryAuthRequest: TwoFactoryAuthRequest): AuthResponse {
        if (!twoFactoryAuthTokenService.validateToken(twoFactoryAuthRequest.email, twoFactoryAuthRequest.code)) {
            throw TwoFactoryAuthException("Two Factor Authentication Failed!")
        }
        val user = userRepository.findByEmail(twoFactoryAuthRequest.email).orElseThrow {
            AuthenticationException("User doesn't exist!")
        }
        return tokenFactoryService.createTokens(user)
    }

}