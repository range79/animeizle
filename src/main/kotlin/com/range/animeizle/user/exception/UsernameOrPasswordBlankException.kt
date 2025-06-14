package com.range.animeizle.user.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UsernameOrPasswordBlankException(message: String?) : AbstractExceptionHandler(message,HttpStatus.BAD_REQUEST)