package com.range.commentservice

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<CommentServiceApplication>().with(TestcontainersConfiguration::class).run(*args)
}
