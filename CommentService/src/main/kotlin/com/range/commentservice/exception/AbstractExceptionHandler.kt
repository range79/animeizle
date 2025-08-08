package com.range.commentservice.exception

import org.springframework.http.HttpStatus

open class AbstractExceptionHandler(message: String, val httpStatus: HttpStatus) : RuntimeException(message)