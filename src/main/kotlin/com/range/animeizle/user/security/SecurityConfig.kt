package com.range.animeizle.user.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig {

@Bean
fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
    http{
        csrf { disable() }
        authorizeHttpRequests {
            authorize("/public", permitAll)
            authorize(anyRequest, permitAll)
        }
    }
    return http.build()
}



}