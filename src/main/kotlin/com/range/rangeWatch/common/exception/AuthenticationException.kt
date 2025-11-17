package com.range.rangeWatch.common.exception

import org.springframework.http.HttpStatus

class AuthenticationException(msg: String): AbstractExceptionHandler(msg, HttpStatus.UNAUTHORIZED)
{
}