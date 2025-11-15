package com.range.animeizle.common.exception

import org.springframework.http.HttpStatus

class AccountDeletedException(msg: String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {
}