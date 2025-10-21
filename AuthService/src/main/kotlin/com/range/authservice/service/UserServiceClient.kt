package com.range.authservice.service

import com.range.authservice.dto.LoginRequest
import com.range.authservice.dto.LoginResponse
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.stereotype.Service


@Service
class UserServiceClient(
    private val webClient: WebClient
) {
    fun login(loginRequest: LoginRequest): LoginResponse {
        return webClient.post()
            .uri("http://user-service/verify")
            .bodyValue(loginRequest)
            .retrieve()
            .bodyToMono(LoginResponse::class.java)
            .block()!!
    }
}
