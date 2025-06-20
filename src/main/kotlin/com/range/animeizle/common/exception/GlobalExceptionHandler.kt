package com.range.animeizle.common.exception

import com.range.animeizle.common.dto.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.Instant

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(AbstractExceptionHandler::class)
    fun  allExceptionHAndler(e: AbstractExceptionHandler): ErrorResponse{
        return ErrorResponse(
            errorCode = e.httpStatus.value(),
            errorMessage = e.message ?: "Unknown error",
            timestamp = Instant.now().toEpochMilli()
        )
    }
}