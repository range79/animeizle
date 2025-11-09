package com.range.animeizle.anime.domain.repository

import com.range.animeizle.anime.domain.entity.Season
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SeasonRepository : JpaRepository<Season, UUID> {
}