package com.range.rangeWatch.user.exception

import com.range.rangeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UsernameAlreadyUsedException(msg: String): AbstractExceptionHandler(msg, HttpStatus.CONFLICT) {
}