package com.range.animeservice.exception

import org.springframework.http.HttpStatus

open class AbstractExceptionHandler (val status: HttpStatus, message: String):RuntimeException(message)