package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.dto.request.UpdateUserRequest
import java.util.*

interface UserCommandService {
    fun deleteMe()
    fun updateUser(id: UUID, updateUserRequest: UpdateUserRequest)
    fun updateUserPassword(id: UUID, newPassword: String)
}
