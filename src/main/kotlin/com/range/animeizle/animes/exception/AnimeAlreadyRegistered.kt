package com.range.animeizle.animes.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class AnimeAlreadyRegistered(message: String): AbstractExceptionHandler(message, HttpStatus.CONFLICT) {
}