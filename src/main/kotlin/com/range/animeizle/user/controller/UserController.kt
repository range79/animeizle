package com.range.animeizle.user.controller

import com.range.animeizle.user.api.UserApi
import com.range.animeizle.user.dto.response.UserResponse
import com.range.animeizle.user.service.AuthService
import com.range.animeizle.user.service.UserService
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class UserController(
    private val userService: UserService
) : UserApi {
    override fun me(): UserResponse {
        return userService.me()
    }

    override fun getUserWithId(id: UUID): UserResponse {
        return userService.getUser(id)
    }

    override fun deleteAccount() {
        return userService.delete()
    }
}