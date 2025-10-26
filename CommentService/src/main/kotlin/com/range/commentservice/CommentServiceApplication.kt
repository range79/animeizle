package com.range.commentservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class CommentServiceApplication

fun main(args: Array<String>) {
    runApplication<CommentServiceApplication>(*args)
}
