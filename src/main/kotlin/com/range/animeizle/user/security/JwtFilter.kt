package com.range.animeizle.user.security

import com.range.animeizle.user.service.impl.CustomUserDetailsService
import com.range.animeizle.common.util.JwtUtil
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtFilter(

    private val jwtUtil: JwtUtil,
    private val customUserDetailsService: CustomUserDetailsService
) : OncePerRequestFilter() {
    private val log: Logger = LoggerFactory.getLogger(JwtFilter::class.java)



    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            val authHeader = request.getHeader("Authorization")

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                val token = authHeader.substring(7)

                val username = jwtUtil.getUserId(token)

                if (SecurityContextHolder.getContext().authentication == null) {
                    val userDetails: UserDetails = customUserDetailsService.loadUserByUsername(username)

                    if (jwtUtil.validateToken(token, userDetails)) {
                        val authToken =
                            UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.authorities
                            )


                        authToken.details = WebAuthenticationDetailsSource().buildDetails(request)

                        SecurityContextHolder.getContext().authentication = authToken
                    }
                }
            }
        } catch (e: Exception) {
            log.error(e.message)
        }
        filterChain.doFilter(request, response)
    }
}
