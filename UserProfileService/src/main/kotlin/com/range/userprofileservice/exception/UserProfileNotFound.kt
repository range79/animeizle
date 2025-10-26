package com.range.userprofileservice.exception

import org.springframework.http.HttpStatus

class UserProfileNotFound(msg: String): AbstractExceptionHandler(HttpStatus.NOT_FOUND,msg) {
}