package com.range.animeWatch.common.filter

import com.range.animeWatch.common.util.DeviceInfoHolder
import com.range.animeWatch.common.util.RequestContext
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletException
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class DeviceFilter : OncePerRequestFilter() {
    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        var ip = request.getHeader("X-Forwarded-For")
        if (ip == null) ip = request.remoteAddr
        val userAgent = request.getHeader("User-Agent")
        DeviceInfoHolder.setContext(RequestContext(ip, userAgent))
        try {
            filterChain.doFilter(request, response)
        } finally {
            DeviceInfoHolder.clear()
        }
    }
}