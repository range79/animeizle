package com.range.animeizle.user.exception

import org.springframework.http.HttpStatus

class AuthenticationException(msg: String): AbstractExceptionHandler(msg, HttpStatus.UNAUTHORIZED)
{
}