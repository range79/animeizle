package com.range.animeWatch.user.service

import com.range.animeWatch.user.domain.entity.User
import com.range.animeWatch.user.dto.request.UpdateUserRequest
import com.range.animeWatch.user.dto.response.UserResponse
import java.util.UUID

interface UserService {
    fun me(): UserResponse;
    fun getUser(id: UUID): User
    fun delete()
   fun update(id: UUID, updateUserRequest: UpdateUserRequest)
   fun updateWithEmail(id: UUID, updateUserRequest: UpdateUserRequest)
}
