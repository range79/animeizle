package com.range.animeizle.user.service

import com.range.animeizle.user.dto.response.UserResponse
import java.util.UUID

interface UserService {
    fun me(): UserResponse;
    fun getUser(id: UUID): UserResponse
    fun delete()
}
