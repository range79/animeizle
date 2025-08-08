package com.range.animeizle.like.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class LikeNotFoundException(message: String) : AbstractExceptionHandler(message, HttpStatus.NOT_FOUND) {
}