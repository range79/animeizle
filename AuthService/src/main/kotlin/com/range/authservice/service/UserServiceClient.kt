package com.range.authservice.service

import com.range.authservice.domain.entity.Role
import com.range.authservice.dto.LoginRequest
import com.range.authservice.dto.VerifyResponse

import com.range.authservice.exception.UserNotFoundException
import com.range.authservice.exception.UserServiceException
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import reactor.core.publisher.Mono
import java.util.UUID

@Service
class UserServiceClient(
    private val webClient: WebClient
) {
    fun verifyUser(loginRequest: LoginRequest): VerifyResponse {
        return webClient.post()
            .uri("http://user-service/verify")
            .bodyValue(loginRequest)
            .retrieve()
            .bodyToMono(VerifyResponse::class.java)
            .onErrorResume { ex: Throwable ->
                when (ex) {
                    is WebClientResponseException.NotFound -> Mono.error(UserNotFoundException("User not found"))
                    is WebClientResponseException -> Mono.error(UserServiceException("User service error: ${ex.statusCode}"))
                    else -> Mono.error(ex)
                }
            }
            .block()!!
    }
    fun getRoles(userId: UUID): Set<Role> {
        return webClient.get()
            .uri("http://user-service/$userId/roles")
            .retrieve()
            .bodyToMono(Array<Role>::class.java)
            .map { it.toSet() }
            .block()!!
    }

}
