package com.range.animeizle

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [UserDetailsServiceAutoConfiguration::class])
class AnimeIzleApplication

fun main(args: Array<String>) {
    runApplication<AnimeIzleApplication>(*args)
}
