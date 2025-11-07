package com.range.animeizle.refreshToken.domain.repository

import com.range.animeizle.refreshToken.domain.entity.RefreshToken
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {
    fun deleteByUserIdAndDevice(userId: UUID, device: String)
}