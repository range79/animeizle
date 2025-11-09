package com.range.animeizle.anime.domain.repository

import com.range.animeizle.anime.domain.entity.Episode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID


interface EpisodeRepository : JpaRepository<Episode, UUID> {
}