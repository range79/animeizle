package com.range.commentservice.exception

import org.springframework.http.HttpStatus


class CommentNotFoundException(msg: String): AbstractExceptionHandler(msg, HttpStatus.NOT_FOUND) {
}