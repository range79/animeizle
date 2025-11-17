package com.range.rangeWatch.common.exception

import com.range.rangeWatch.common.dto.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(AbstractExceptionHandler::class)
    fun handlerAbstractExceptionHandler(e: AbstractExceptionHandler, request: HttpServletRequest): ErrorResponse {
        return ErrorResponse(
            message = e.msg,
            status = e.status,
            path = request.requestURL.toString(),
            method = request.method,
        )
    }
    @ExceptionHandler(Exception::class)
    fun handlerServerError(e: Exception, request: HttpServletRequest): ErrorResponse {
        return ErrorResponse(
            message = e.message ?: "Something went wrong",
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            path = request.requestURL.toString(),
            method = request.method,
        )
    }


}