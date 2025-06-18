package com.range.animeizle.animes.domain.repository

import com.range.animeizle.animes.domain.model.Season
import org.springframework.data.jpa.repository.JpaRepository


interface SeasonRepository : JpaRepository<Season?, Long?>{
    fun findSeasonByAnime_Id(animeId: Long): List<Season>
}
