package com.range.animeWatch.token.refreshToken.exception

import com.range.animeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UnTrustedDeviceException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST){
}