package com.range.animeizle.animes.service.impl

import com.range.animeizle.animes.domain.entity.Season
import com.range.animeizle.animes.domain.repository.AnimeRepository
import com.range.animeizle.animes.domain.repository.SeasonRepository
import com.range.animeizle.animes.dto.request.SeasonRequest
import com.range.animeizle.animes.dto.response.SeasonResponse
import com.range.animeizle.animes.exception.AnimeNotFoundException
import com.range.animeizle.animes.exception.SeasonNotFoundException
import com.range.animeizle.animes.mapper.SeasonMapper
import com.range.animeizle.animes.service.SeasonService
import org.springframework.stereotype.Service

@Service
class SeasonServiceImpl(val seasonRepository: SeasonRepository,
                        val seasonMapper: SeasonMapper,
                        val animeRepository: AnimeRepository) : SeasonService {
    override fun findAllAnimeSeasons(animeid: Long): List<SeasonResponse> {
        return   seasonRepository.findSeasonByAnime_Id(animeid).map (seasonMapper::seasonToSeasonResponse )
    }

    override fun findSeason(id: Long): Season {
        return seasonFinder(id)
    }

    override fun removeSeason(id: Long,details: Boolean): SeasonResponse? {

        val season = seasonFinder(id)
        seasonRepository.delete(season)
        return  if(details){
            seasonMapper.seasonToSeasonResponse(season)
        }else {
            null
        }

    }
    override fun add(seasonRequest: SeasonRequest): SeasonResponse {
        val anime = animeRepository.findById(seasonRequest.animeId)
            .orElseThrow{AnimeNotFoundException("Anime not found with id ${seasonRequest.animeId}")}
        val season = Season(
            id= 0 ,
            anime = anime,
            seasonSize = seasonRequest.seasonSize,
            seasonNumber = seasonRequest.seasonNumber,
        )
        val seasonSave = seasonRepository.save(season)
        return  seasonMapper.seasonToSeasonResponse(seasonSave)
    }

    override fun update(
        id: Long,
        season: Season
    ): SeasonResponse {
    TODO()

    }


    private fun seasonFinder (id: Long): Season {
        return seasonRepository.findById(id)
            .orElseThrow{ SeasonNotFoundException("Season Not Found with id $id") }
    }
}
