package com.range.animeizle.common.exception

import org.springframework.http.HttpStatus

class AuthenticationException(msg: String): AbstractExceptionHandler(msg, HttpStatus.UNAUTHORIZED)
{
}