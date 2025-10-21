package com.range.userservice.exception

import org.springframework.http.HttpStatus

class PasswordResetTokenException(msg: String): AbstractExceptionHandler(HttpStatus.BAD_REQUEST,msg)