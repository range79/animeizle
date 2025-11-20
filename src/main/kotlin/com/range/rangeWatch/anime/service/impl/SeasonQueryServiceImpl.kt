package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.entity.Season
import com.range.rangeWatch.anime.domain.repository.SeasonRepository
import com.range.rangeWatch.anime.exception.SeasonNotFoundException
import com.range.rangeWatch.anime.service.SeasonQueryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SeasonQueryServiceImpl
    (private val seasonRepository: SeasonRepository)
    :SeasonQueryService {
    override fun animeSeasons(
        animeId: UUID,
        pageable: Pageable
    ): Page<Season> {
        return seasonRepository.findByAnimeId(animeId,pageable)
    }

    override fun getSeason(id: UUID): Season {
        return seasonRepository.findById(id).orElseThrow{SeasonNotFoundException("Season Not Found")}
    }
}