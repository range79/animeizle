package com.range.rangeWatch.anime.domain.repository

import com.range.rangeWatch.anime.domain.entity.Anime
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AnimeRepository : JpaRepository<Anime, UUID> {
    fun findByTitleContainingIgnoreCase(title: String,pageable: Pageable): Page<Anime>
}