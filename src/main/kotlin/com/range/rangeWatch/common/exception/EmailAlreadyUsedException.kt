package com.range.rangeWatch.common.exception

import org.springframework.http.HttpStatus

class EmailAlreadyUsedException(msg: String): AbstractExceptionHandler(msg, HttpStatus.CONFLICT)