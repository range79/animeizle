package com.range.animeizle.animes.domain.repository

import com.range.animeizle.animes.domain.model.Episode
import org.springframework.data.jpa.repository.JpaRepository

interface EpisodeRepository : JpaRepository<Episode?, JpaRepository<*, *>?>
