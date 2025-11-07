package com.range.animeizle.common.security

import com.range.muhasebe.common.security.jwt.JWTFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
class SecurityConfig(private val jwtFilter: JWTFilter,
                    ) {
    @Value("\${api.prefix}")
    private lateinit var prefix: String
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http {
            csrf { disable() }
            authorizeHttpRequests {
                // Auth endpoints
                authorize("$prefix/auth/**", permitAll)

                // Swagger
                authorize("/v3/**", permitAll)
                authorize("/swagger-ui/**", permitAll)
                authorize("/swagger-resources/**", permitAll)
                authorize("/swagger-ui.html", permitAll)
            }



            http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
        }
            return http.build()
        }


}