package com.range.userservice.domain.repository.impl

import com.range.userservice.domain.entity.PasswordResetToken
import com.range.userservice.domain.repository.PasswordResetTokenRepository
import com.redis.testcontainers.RedisContainer
import io.lettuce.core.RedisClient
import io.lettuce.core.api.sync.RedisCommands

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.UUID
import kotlin.test.assertEquals

@DataRedisTest
@Testcontainers
class PasswordResetTokenRepositoryImplTest {

    companion object {
        @Container
        @JvmStatic
        val container: RedisContainer = RedisContainer(
            RedisContainer.DEFAULT_IMAGE_NAME.withTag(RedisContainer.DEFAULT_TAG)
        )
    }
    @Autowired
    lateinit var passwordResetTokenRepository: PasswordResetTokenRepository

    @Test
    fun testPing() {
        val redisURI = container.redisURI
        val client = RedisClient.create(redisURI)
        client.connect().use { connection ->
            val commands: RedisCommands<String, String> = connection.sync()
            assertEquals("PONG", commands.ping())
        }
    }



    @Test
    fun saveToken() {
        var token =PasswordResetToken.generate("random@gmail")
        passwordResetTokenRepository.saveToken(token)
    }

    @Test
    fun findByToken() {
    }

    @Test
    fun delete() {
    }

}