package com.range.rangeWatch.user.service

import com.range.rangeWatch.user.domain.entity.User
import java.util.UUID

interface UserQueryService {
    fun me(): User
    fun getUser(id: UUID): User
    fun getUserWithEmail(email: String): User
}
