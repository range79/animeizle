package com.range.animeizle.animes.domain.repository

import com.range.animeizle.animes.domain.entity.Anime
import org.springframework.data.jpa.repository.JpaRepository

interface  AnimeRepository: JpaRepository<Anime, Long>{

}