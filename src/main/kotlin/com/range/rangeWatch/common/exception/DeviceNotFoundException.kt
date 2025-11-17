package com.range.rangeWatch.common.exception

import org.springframework.http.HttpStatus

class DeviceNotFoundException (msg: String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {
}