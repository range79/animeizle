package com.range.userservice.exception

import org.springframework.http.HttpStatus

class EmailNotFoundException(msg: String): AbstractExceptionHandler(HttpStatus.NOT_FOUND,msg) {
}