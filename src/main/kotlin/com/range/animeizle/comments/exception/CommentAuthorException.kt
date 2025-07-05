package com.range.animeizle.comments.exception

import com.range.animeizle.common.exception.AbstractExceptionHandler
import org.springframework.http.HttpStatus

class CommentAuthorException(message: String): AbstractExceptionHandler(message,HttpStatus.UNAUTHORIZED){
}