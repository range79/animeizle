package com.range.animeizle.anime.domain.repository

import com.range.animeizle.anime.domain.entity.Anime
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AnimeRepository : JpaRepository<Anime, UUID> {
}