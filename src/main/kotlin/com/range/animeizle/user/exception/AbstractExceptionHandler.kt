package com.range.animeizle.user.exception

import org.springframework.http.HttpStatus

open class AbstractExceptionHandler(val msg: String, val status: HttpStatus): RuntimeException(msg)
{
}