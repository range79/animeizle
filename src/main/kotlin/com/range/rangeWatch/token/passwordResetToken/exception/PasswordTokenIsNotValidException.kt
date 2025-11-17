package com.range.rangeWatch.token.passwordResetToken.exception

import com.range.rangeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class PasswordTokenIsNotValidException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {
}