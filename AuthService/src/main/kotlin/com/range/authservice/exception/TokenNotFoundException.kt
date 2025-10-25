package com.range.authservice.exception

import org.springframework.http.HttpStatus

class TokenNotFoundException(msg: String): AbstractExceptionHandler(HttpStatus.NOT_FOUND,msg) {
}