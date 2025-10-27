package com.range.animeservice.domain.repository

import com.range.configserver.domain.entity.Anime
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface AnimeRepository : JpaRepository<Anime, UUID> {
}