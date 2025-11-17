 package com.range.rangeWatch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [UserDetailsServiceAutoConfiguration::class])
class AnimeWatchApplication

fun main(args: Array<String>) {
    runApplication<AnimeWatchApplication>(*args)
}
