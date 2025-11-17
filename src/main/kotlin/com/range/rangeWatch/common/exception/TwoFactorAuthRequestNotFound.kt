package com.range.rangeWatch.common.exception

import org.springframework.http.HttpStatus

class TwoFactorAuthRequestNotFound(msg:String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {
}