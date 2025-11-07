package com.range.animeizle.accessToken.domain.repository

import com.range.animeizle.accessToken.domain.entity.AccessToken
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface AccessTokenRepository: CrudRepository<AccessToken, String> {
    fun deleteByUserIdAndDevice(userId: UUID, device: String)
}