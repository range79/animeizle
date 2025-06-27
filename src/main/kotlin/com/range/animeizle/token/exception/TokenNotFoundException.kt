package com.range.animeizle.token.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class TokenNotFoundException(message:String): AbstractExceptionHandler(message, HttpStatus.NOT_FOUND){
}