package com.range.animeizle.user.service

import com.range.animeizle.token.tokenfactory.dto.TokenFactoryRequest
import com.range.animeizle.user.domain.entity.User
import com.range.animeizle.user.dto.request.UpdateUserRequest
import com.range.animeizle.user.dto.response.UserResponse
import java.util.UUID

interface UserService {
    fun me(): UserResponse;
    fun getUser(id: UUID): User
    fun delete()
   fun update(id: UUID, updateUserRequest: UpdateUserRequest)
   fun updateWithEmail(id: UUID, updateUserRequest: UpdateUserRequest)
}
