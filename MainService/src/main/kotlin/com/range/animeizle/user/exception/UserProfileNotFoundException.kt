package com.range.animeizle.user.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UserProfileNotFoundException(message: String): AbstractExceptionHandler(message, HttpStatus.NOT_FOUND) {
}