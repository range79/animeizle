package com.range.userservice.mapper

import com.range.userservice.domain.entity.Role
import com.range.userservice.domain.entity.User
import com.range.userservice.dto.RegisterRequest
import org.apache.kafka.common.config.types.Password

class UserMapper {
    fun RegisterRequest.toModel(password: String): User {
        return User(
            id = null, email = email,
            username = username,
            password = password,
            role = Role.ROLE_USER,
        )
    }

}