package com.range.animeizle.user.exception

import org.springframework.http.HttpStatus

class UsernameAlreadyUsedException(msg: String): AbstractExceptionHandler(msg, HttpStatus.CONFLICT) {
}