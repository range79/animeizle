package com.range.animeWatch.token.twoFactoryAuth.exception

import com.range.animeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class TwoFactoryAuthTokenNotFoundException(
    message: String,
): AbstractExceptionHandler(message, HttpStatus.UNAUTHORIZED) {
}