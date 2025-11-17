package com.range.animeWatch.token.passwordResetToken.exception

import com.range.animeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class PasswordTokenIsNotValidException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {
}