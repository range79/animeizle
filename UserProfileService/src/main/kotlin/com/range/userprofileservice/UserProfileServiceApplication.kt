package com.range.userprofileservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class UserProfileServiceApplication

fun main(args: Array<String>) {
	runApplication<UserProfileServiceApplication>(*args)
}
