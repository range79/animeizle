package com.range.animeizle.animes.domain.repository

import com.range.animeizle.animes.domain.entity.Episode
import org.springframework.data.jpa.repository.JpaRepository

interface EpisodeRepository : JpaRepository<Episode, Long> {
    fun findBySeason_Id(seasonId: Long): List<Episode>
}
