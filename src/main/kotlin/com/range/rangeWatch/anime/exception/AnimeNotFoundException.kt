package com.range.rangeWatch.anime.exception

import com.range.rangeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class AnimeNotFoundException(msg:String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {
}