package com.range.animeizle.user.mapper

import com.range.animeizle.user.domain.entity.Role
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.dto.RegisterRequest
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun registerRequestToUserEntity(registerRequest: RegisterRequest): User {
        return User(username = registerRequest.username,
            password = registerRequest.password,
            email = registerRequest.email,
            role = Role.ROLE_USER
        )
    }








}