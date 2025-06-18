package com.range.animeizle.animes.service.impl

import com.range.animeizle.animes.domain.model.Season
import com.range.animeizle.animes.domain.repository.SeasonRepository
import com.range.animeizle.animes.dto.SeasonResponse
import com.range.animeizle.animes.service.SeasonService
import org.springframework.stereotype.Service

@Service
class SeasonServiceImpl(val seasonRepository: SeasonRepository) : SeasonService {
    override fun findAllAnimeSeasons(animeid: Long): List<Season> {
     return   seasonRepository.findSeasonByAnime_Id(animeid)
    }

    override fun findSeason(seasonNumber: Int): SeasonResponse {
        TODO("Not yet implemented")
    }

    override fun removeSeason(id: Long) {
        TODO("Not yet implemented")
    }
}
