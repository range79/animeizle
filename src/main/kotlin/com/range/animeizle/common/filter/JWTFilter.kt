package com.range.muhasebe.common.security.jwt

import com.range.muhasebe.common.exception.TokenException
import com.range.muhasebe.common.security.details.CustomUserDetailsService
import com.range.muhasebe.common.service.JWTBlacklistService
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
import kotlin.text.startsWith
import kotlin.text.substring

@Component
class JWTFilter(

    private val jwtUtil: JWTUtil,

    private val customUserDetailsService: CustomUserDetailsService
) : OncePerRequestFilter() {
    private val log: Logger = LoggerFactory.getLogger(JWTFilter::class.java)



    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            var token: String? = null

            val authHeader = request.getHeader("Authorization")
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7)
            }


//            if (token == null) {
//                val cookies = request.cookies
//                token = cookies?.firstOrNull { it.name == "jwt" }?.value
//            }


            if (token != null && SecurityContextHolder.getContext().authentication == null) {
                val id = jwtUtil.getUserId(token)
                if (jwtBlacklistService.checkToken(token)){
                    throw TokenException(null)
                }
                val userDetails: UserDetails = customUserDetailsService.loadUserByUserID(id)
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

        } catch (e: Exception) {
            log.error(e.message)
            SecurityContextHolder.clearContext()
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired JWT token.")
            return
        }
        filterChain.doFilter(request, response)
    }
}