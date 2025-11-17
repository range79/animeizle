package com.range.animeWatch.anime.exception

import com.range.animeWatch.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class AnimeNotFoundException(msg:String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {
}