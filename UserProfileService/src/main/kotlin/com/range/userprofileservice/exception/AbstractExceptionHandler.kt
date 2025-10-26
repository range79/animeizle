package com.range.userprofileservice.exception

import org.springframework.http.HttpStatus

open class AbstractExceptionHandler(val status: HttpStatus, msg: String): RuntimeException(msg) {
}