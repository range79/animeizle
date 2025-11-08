package com.range.animeizle.token.passwordResetToken.exceptıon

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class PasswordTokenIsNotValidException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST) {
}