 package com.range.rangeWatch

import org.springframework.boot.autoconfigure.SpringBootApplication

import org.springframework.boot.runApplication
import org.springframework.boot.security.autoconfigure.UserDetailsServiceAutoConfiguration

 @SpringBootApplication(exclude = [UserDetailsServiceAutoConfiguration::class])
class RangeWatchApplication

fun main(args: Array<String>) {
    runApplication<RangeWatchApplication>(*args)
}
