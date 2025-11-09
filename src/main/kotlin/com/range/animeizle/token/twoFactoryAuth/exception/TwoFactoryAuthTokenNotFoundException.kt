package com.range.animeizle.token.twoFactoryAuth.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class TwoFactoryAuthTokenNotFoundException(
    message: String,
): AbstractExceptionHandler(message, HttpStatus.UNAUTHORIZED) {
}