package com.range.rangeWatch.anime.domain.repository

import com.range.rangeWatch.anime.domain.entity.Season
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface SeasonRepository : JpaRepository<Season, UUID> {
    fun findByAnimeId(animeId: UUID,pageable: Pageable): Page<Season>
}