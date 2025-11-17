package com.range.rangeWatch.token.refreshToken.domain.repository

import com.range.rangeWatch.token.refreshToken.domain.entity.RefreshToken
import org.springframework.data.repository.CrudRepository
import java.util.*

interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
    fun deleteByUserIdAndDevice(userId: UUID, device: String)
    fun deleteAllByUserId(userId: UUID)
}