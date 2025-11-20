package com.range.rangeWatch.user.mapper

import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.user.dto.response.UserResponse
import org.springframework.stereotype.Component

@Component
class UserMapper {


    fun toUserResponse(user: User): UserResponse {
        return UserResponse(
            id = user.id,
            username = user.username,
        )
    }


}