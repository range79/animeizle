package com.range.animeizle.user.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UsernameAlreadyRegisteredException(message: String?) : AbstractExceptionHandler(message, HttpStatus.CONFLICT)