package com.range.animeizle.user.mapper

import com.range.animeizle.user.domain.model.Role
import com.range.animeizle.user.domain.model.User
import com.range.animeizle.user.dto.RegisterRequest
import com.range.animeizle.user.dto.RegisterResponse
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
fun userEntityToRegisterResponse(user: User): RegisterResponse {
    return RegisterResponse(
        username = user.username
    )
}








}