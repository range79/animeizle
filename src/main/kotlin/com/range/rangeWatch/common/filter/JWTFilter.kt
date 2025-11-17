package com.range.rangeWatch.common.filter

import com.range.rangeWatch.common.security.CustomUserDetailsService
import com.range.rangeWatch.common.util.JWTUtil
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

                val userDetails: UserDetails = customUserDetailsService.loadUserById(id)
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