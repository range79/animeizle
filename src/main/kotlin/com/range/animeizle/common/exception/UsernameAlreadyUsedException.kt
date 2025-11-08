package com.range.animeizle.common.exception

import org.springframework.http.HttpStatus

class UsernameAlreadyUsedException(msg: String): AbstractExceptionHandler(msg, HttpStatus.CONFLICT) {
}