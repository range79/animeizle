package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.domain.repository.SeasonRepository
import com.range.rangeWatch.anime.dto.request.SeasonRequest
import com.range.rangeWatch.anime.service.SeasonService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeasonServiceImpl(
    private val seasonRepository: SeasonRepository,
): SeasonService {


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