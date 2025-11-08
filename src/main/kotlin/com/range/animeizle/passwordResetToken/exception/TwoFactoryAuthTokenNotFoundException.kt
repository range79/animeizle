package com.range.animeizle.passwordResetToken.exception

import com.range.animeizle.user.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class TwoFactoryAuthTokenNotFoundException(
    message: String,
): AbstractExceptionHandler(message, HttpStatus.UNAUTHORIZED) {
}