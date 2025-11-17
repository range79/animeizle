package com.range.animeWatch.user.service.impl

import com.range.animeWatch.common.exception.AuthenticationException
import com.range.animeWatch.common.exception.TwoFactoryAuthException
import com.range.animeWatch.token.tokenfactory.service.TokenFactoryService
import com.range.animeWatch.token.twoFactoryAuth.service.TwoFactoryAuthTokenService
import com.range.animeWatch.user.domain.repository.UserRepository
import com.range.animeWatch.user.dto.request.TwoFactoryAuthRequest
import com.range.animeWatch.user.dto.response.AuthResponse
import com.range.animeWatch.user.service.TwoFactoryAuthService
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