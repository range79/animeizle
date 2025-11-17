package com.range.animeWatch.user.controller

import com.range.animeWatch.user.api.UserApi
import com.range.animeWatch.user.dto.response.UserResponse
import com.range.animeWatch.user.service.UserService
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