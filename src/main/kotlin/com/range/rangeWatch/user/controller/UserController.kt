package com.range.rangeWatch.user.controller

import com.range.rangeWatch.user.api.UserApi
import com.range.rangeWatch.user.dto.response.UserResponse
import com.range.rangeWatch.user.service.UserCommandService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userCommandService: UserCommandService
) : UserApi {
    override fun me(): UserResponse {
TODO()
    //        return userCommandService.me()
    }

//    override fun getUserWithId(id: UUID): UserResponse {
//        return userService.getUser(id)
//    }

    override fun deleteAccount() {
        return userCommandService.deleteMe()
    }
}