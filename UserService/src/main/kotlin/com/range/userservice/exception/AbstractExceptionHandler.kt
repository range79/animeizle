package com.range.userservice.exception

import org.springframework.http.HttpStatus

open class AbstractExceptionHandler (val https: HttpStatus, message: String):RuntimeException(message)