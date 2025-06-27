package com.range.animeizle.token.domain.repository

import com.range.animeizle.token.domain.entity.RefreshToken
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RefreshTokenRepository: JpaRepository<RefreshToken, UUID> {
   fun findByToken(token: String): RefreshToken?
}