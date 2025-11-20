package com.range.rangeWatch.common.exception

import org.springframework.http.HttpStatus

class AmazonS3Exception(msg: String): AbstractExceptionHandler(msg, HttpStatus.INTERNAL_SERVER_ERROR)
