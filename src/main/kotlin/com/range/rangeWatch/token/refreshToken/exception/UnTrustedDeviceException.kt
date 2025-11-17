package com.range.rangeWatch.token.refreshToken.exception

import com.range.rangeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UnTrustedDeviceException(msg: String): AbstractExceptionHandler(msg, HttpStatus.BAD_REQUEST){
}