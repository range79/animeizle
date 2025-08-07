package com.range.animeizle.user.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class RequiredFieldNullException(msg: String) : AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {
}