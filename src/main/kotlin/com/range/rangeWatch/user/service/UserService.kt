package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.domain.entity.User
import com.range.rangeWatch.user.dto.request.UpdateUserRequest
import com.range.rangeWatch.user.dto.response.UserResponse
import java.util.UUID

interface UserService {
    fun me(): UserResponse;
    fun getUser(id: UUID): User
    fun deleteMe()
    fun updateUser(id: UUID, updateUserRequest: UpdateUserRequest)
    fun getUserWithEmail(email: String): User
    fun updateUserPassword(id: UUID, newPassword: String)
}
