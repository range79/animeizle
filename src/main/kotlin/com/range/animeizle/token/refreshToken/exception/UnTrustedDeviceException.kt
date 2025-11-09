package com.range.animeizle.token.refreshToken.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UnTrustedDeviceException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST){
}