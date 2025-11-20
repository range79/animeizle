package com.range.rangeWatch.userprofile.exception

import com.range.rangeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class UserProfileNotFoundException (msg: String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND){
}