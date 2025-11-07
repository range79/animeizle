package com.range.animeizle.accessToken.exception

import com.range.animeizle.user.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UnTrustedDeviceException(msg: String): AbstractExceptionHandler (msg, HttpStatus.BAD_REQUEST){
}