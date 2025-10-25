package com.range.userservice

import com.range.userservice.domain.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceApplicationTests {

    @Autowired
    private lateinit var userRepository: UserRepository


	@Test
	fun contextLoads() {
	}

}
