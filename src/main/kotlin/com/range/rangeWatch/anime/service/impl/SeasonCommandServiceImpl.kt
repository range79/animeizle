package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.repository.SeasonRepository
import com.range.rangeWatch.anime.dto.request.SeasonRequest
import com.range.rangeWatch.anime.exception.SeasonNotFoundException
import com.range.rangeWatch.anime.mapper.SeasonMapper
import com.range.rangeWatch.anime.service.AnimeQueryService
import com.range.rangeWatch.anime.service.SeasonCommandService
import org.springframework.stereotype.Service
import java.util.*

@Service
class SeasonCommandServiceImpl(
    private val seasonRepository: SeasonRepository,
    private val animeQueryService: AnimeQueryService,
    private val seasonMapper: SeasonMapper,

) : SeasonCommandService {


    override fun create(seasonRequest: SeasonRequest) {
        val season = seasonMapper.toSeason(seasonRequest)
        val anime = animeQueryService.getById(seasonRequest.animeId)
        season.anime = anime
        seasonRepository.save(season)


    }

    override fun deleteSeason(id: UUID) {
        seasonRepository.deleteById(id)
    }

    override fun updateSeason(id: UUID, seasonRequest: SeasonRequest) {
        val season =seasonRepository.findById(id).orElseThrow{
            SeasonNotFoundException("Season not found")
        }
        val anime = animeQueryService.getById(seasonRequest.animeId)

        season.title = seasonRequest.title
        season.description = seasonRequest.description
        season.anime = anime
        seasonRepository.save(season)
    }
}