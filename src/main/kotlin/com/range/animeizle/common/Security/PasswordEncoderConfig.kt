package com.range.animeizle.common.Security

import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder

@Configuration
class PasswordEncoderConfig {
    private val saltLength = 0
    private val hashLength = 0
    private val parallelism = 0
    private val memory = 0
    private val iterations = 0
    val passwordEncoder: Argon2PasswordEncoder
        get() = Argon2PasswordEncoder(
            saltLength,
            hashLength,
            parallelism,
            memory,
            iterations
        )
}
