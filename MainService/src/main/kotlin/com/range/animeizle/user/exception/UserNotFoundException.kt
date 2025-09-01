package com.range.animeizle.user.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UserNotFoundException(message:String): AbstractExceptionHandler(message, httpStatus = HttpStatus.NOT_FOUND)