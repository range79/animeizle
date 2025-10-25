package com.range.userservice.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.range.userservice.config.SecurityConfig
import com.range.userservice.domain.entity.Role
import com.range.userservice.domain.entity.User
import com.range.userservice.domain.repository.UserRepository
import com.range.userservice.dto.ForgotPasswordRequest
import com.range.userservice.dto.RegisterRequest
import com.range.userservice.dto.VerifyRequest
import com.range.userservice.dto.VerifyResponse
import com.range.userservice.service.UserService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.*

//@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@EnableAutoConfiguration(
    exclude = [
        org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration::class,
        org.springframework.kafka.annotation.KafkaListenerAnnotationBeanPostProcessor::class,
        org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration::class
    ]
)
@Testcontainers
@TestPropertySource("classpath:application-test.properties")
@Import(SecurityConfig::class)
class UserControllerTest(@Autowired private val objectMapper: ObjectMapper) {
    @MockitoBean
    private lateinit var mockMvc: MockMvc
    @Autowired
    private lateinit var userRepository: UserRepository
    @BeforeEach
    fun setUp() {
        userRepository.save(User(id = UUID.randomUUID(),
            username = "testUser",
            password = "testPassword",
            emailVerified = false,
            email = "test@gmail.com",
            role=setOf(Role.ROLE_USER),
            twoFactorEnabled = false,
            ))
    }

        companion object {
            @JvmStatic
            val postgres = PostgreSQLContainer<Nothing>("postgres:15").apply {
                withDatabaseName("testdb")
                withUsername("sa")
                withPassword("sa")
                start()
            }
        }


    @MockitoBean
    private lateinit var userService: UserService
    @Test
    fun shouldVerifyUser() {
        val verifyRequest=VerifyRequest(username = "xx", password = "xx")
        val verifyResponse= VerifyResponse(userId = UUID.fromString("2f05a24a-3bfd-4191-9a4e-4a0137ced6f2"), roles = setOf(Role.ROLE_USER))
        `when`(userService.verifyUser(verifyRequest)).thenReturn(verifyResponse)
        mockMvc.post("/api/v1/verify") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(verifyRequest)
        }.andExpect {
                status { isOk() }
                jsonPath("$.userId") { value("2f05a24a-3bfd-4191-9a4e-4a0137ced6f2") }
            }

    }

    @Test
    fun register() {
        val registerRequest= RegisterRequest(username = "xx", password = "xx", email = "xx@xx")
        mockMvc.post("/api/v1/register") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(registerRequest)
        }.andExpect { status { isCreated() }
        }

    }

    @Test
    fun forgotPassword() {
        val forgotPasswordRequest= ForgotPasswordRequest(email = "string@gmail.com")

        mockMvc.post("/api/v1/forgot-Password") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(forgotPasswordRequest)
        }.andExpect { status { isOk() } }
    }

    @Test
    fun resetPassword() {
    }

    @Test
    fun getUserRoles() {
    }

}