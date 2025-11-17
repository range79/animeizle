package com.range.animeWatch.common.exception

import org.springframework.http.HttpStatus

class InvalidUsernameException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {

}
