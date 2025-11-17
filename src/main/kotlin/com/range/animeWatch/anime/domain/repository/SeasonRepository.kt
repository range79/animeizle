package com.range.animeWatch.anime.domain.repository

import com.range.animeWatch.anime.domain.entity.Season
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SeasonRepository : JpaRepository<Season, UUID> {
}