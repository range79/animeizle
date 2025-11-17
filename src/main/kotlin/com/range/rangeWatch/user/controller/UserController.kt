package com.range.rangeWatch.user.controller

import com.range.rangeWatch.user.api.UserApi
import com.range.rangeWatch.user.dto.response.UserResponse
import com.range.rangeWatch.user.service.UserService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) : UserApi {
    override fun me(): UserResponse {
        return userService.me()
    }

//    override fun getUserWithId(id: UUID): UserResponse {
//        return userService.getUser(id)
//    }

    override fun deleteAccount() {
        return userService.deleteMe()
    }
}