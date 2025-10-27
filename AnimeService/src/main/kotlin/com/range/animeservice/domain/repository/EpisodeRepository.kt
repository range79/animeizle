package com.range.animeservice.domain.repository

import com.range.configserver.domain.entity.Episode
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface EpisodeRepository: JpaRepository<Episode, UUID> {
}