package com.range.rangeWatch.token.twoFactoryAuth.exception

import com.range.rangeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class TwoFactoryAuthTokenNotFoundException(
    message: String,
): AbstractExceptionHandler(message, HttpStatus.UNAUTHORIZED) {
}