package com.range.commentservice.exception

import org.springframework.http.HttpStatus

class CommentAuthorException(message: String): AbstractExceptionHandler(message,HttpStatus.UNAUTHORIZED){
}