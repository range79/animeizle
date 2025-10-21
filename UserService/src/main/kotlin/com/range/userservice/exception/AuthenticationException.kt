package com.range.userservice.exception

import org.springframework.http.HttpStatus

class AuthenticationException(message: String): AbstractExceptionHandler(HttpStatus.NOT_FOUND,message) {
}