package com.range.userprofileservice.exception

import org.springframework.http.HttpStatus


class UserNotExitsException(msg: String): AbstractExceptionHandler(HttpStatus.BAD_REQUEST,msg)
