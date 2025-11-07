package com.range.animeizle.user.exception

import org.springframework.http.HttpStatus

class EmailAlreadyUsedException(msg: String): AbstractExceptionHandler(msg, HttpStatus.CONFLICT)