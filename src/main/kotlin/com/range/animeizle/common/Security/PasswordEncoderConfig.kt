package com.range.animeizle.common.Security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder

@Configuration
class PasswordEncoderConfig {
    @Value("\${argon2.saltLength}")
    private var saltLength = 0;

    @Value("\${argon2.hashLength}")
    private val hashLength = 0

    @Value("\${argon2.parallelism}")
    private val parallelism = 0

    @Value("\${argon2.memory}")
    private val memory = 0

    @Value("\${argon2.iterations}")
    private val iterations = 0

    @Bean
    fun passwordEncoder(): Argon2PasswordEncoder {
        return Argon2PasswordEncoder(
            saltLength,
            hashLength,
            parallelism,
            memory,
            iterations
        )
    }
}
