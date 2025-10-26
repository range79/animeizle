package com.range.userservice.exception

import com.range.userservice.dto.ErrorResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptionHandler {
    companion object {
        private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)
    }

    @ExceptionHandler(AbstractExceptionHandler::class)
    fun handlerAbstractExceptionHandler(e: AbstractExceptionHandler): ResponseEntity<ErrorResponse> {
       logger.info("Exception handler ${e.status}")
        val error = ErrorResponse(
            message = e.message.toString(),
            status = e.status,
            timestamp = Instant.now()
        )
        return ResponseEntity(error, e.status)
    }

    @ExceptionHandler(Exception::class)
    fun handlerExceptionHandler(e: Exception): ResponseEntity<ErrorResponse> {
        logger.error("Unhandled exception", e)
        val error = ErrorResponse(
            message = "Internal server error",
            status = HttpStatus.INTERNAL_SERVER_ERROR,
            timestamp = Instant.now()
        )
        return ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}