package com.range.rangeWatch.user.api

import com.range.rangeWatch.user.dto.request.UpdateUserRequest
import com.range.rangeWatch.user.dto.response.UserResponse
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RequestMapping("\${api.prefix}/users")
interface UserCommandApi {
    @DeleteMapping("/delete")
    fun deleteMe()

}
