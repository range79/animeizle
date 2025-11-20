package com.range.rangeWatch.user.exception

import com.range.rangeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class AuthenticationException(msg: String): AbstractExceptionHandler(msg, HttpStatus.UNAUTHORIZED)
{
}