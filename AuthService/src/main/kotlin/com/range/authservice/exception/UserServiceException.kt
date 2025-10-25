package com.range.authservice.exception

import org.springframework.http.HttpStatus

class UserServiceException(msg: String): AbstractExceptionHandler(HttpStatus.SERVICE_UNAVAILABLE, msg)
