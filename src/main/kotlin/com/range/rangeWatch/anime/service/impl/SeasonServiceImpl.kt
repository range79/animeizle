package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.domain.repository.SeasonRepository
import com.range.rangeWatch.anime.dto.SeasonRequest
import com.range.rangeWatch.anime.service.SeasonService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeasonServiceImpl(
    private val seasonRepository: SeasonRepository,
): SeasonService {
    override fun animeSeasons(
        animeId: Long,
        pageable: Pageable
    ): Page<Season> {
       TODO()
    }

    override fun getSeason(id: UUID): Season {
        TODO("Not yet implemented")
    }

    override fun create(seasonRequest: SeasonRequest): Season {
        TODO("Not yet implemented")
    }

    override fun deleteSeason(id: UUID) {
        TODO("Not yet implemented")
    }

    override fun updateSeason(id: UUID, seasonRequest: SeasonRequest) {
        TODO("Not yet implemented")
    }
}