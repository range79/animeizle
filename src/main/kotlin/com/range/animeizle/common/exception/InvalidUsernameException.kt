package com.range.animeizle.common.exception

import org.springframework.http.HttpStatus

class InvalidUsernameException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {

}
