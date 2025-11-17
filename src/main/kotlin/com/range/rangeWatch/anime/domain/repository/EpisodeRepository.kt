package com.range.rangeWatch.anime.domain.repository

import com.range.rangeWatch.anime.domain.entity.Episode
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID


interface EpisodeRepository : JpaRepository<Episode, UUID> {
}