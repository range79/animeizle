package com.range.rangeWatch.user.controller

import com.range.rangeWatch.user.api.UserCommandApi
import com.range.rangeWatch.user.dto.response.UserResponse
import com.range.rangeWatch.user.mapper.UserMapper
import com.range.rangeWatch.user.service.UserCommandService
import com.range.rangeWatch.user.service.UserQueryService
import org.springframework.web.bind.annotation.RestController

@RestController
class UserCommandController(
    private val userCommandService: UserCommandService,

) : UserCommandApi {
    override fun deleteMe() {
        return userCommandService.deleteMe()
    }
}