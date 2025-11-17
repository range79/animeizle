package com.range.animeWatch.anime.domain.repository

import com.range.animeWatch.anime.domain.entity.Episode
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID


interface EpisodeRepository : JpaRepository<Episode, UUID> {
}