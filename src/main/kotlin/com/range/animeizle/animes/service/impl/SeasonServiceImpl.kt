package com.range.animeizle.animes.service.impl

import com.range.animeizle.animes.domain.entity.Anime
import com.range.animeizle.animes.domain.entity.Season
import com.range.animeizle.animes.domain.repository.AnimeRepository
import com.range.animeizle.animes.domain.repository.SeasonRepository
import com.range.animeizle.animes.dto.request.SeasonRequest
import com.range.animeizle.animes.dto.response.SeasonResponse
import com.range.animeizle.animes.exception.AnimeNotFoundException
import com.range.animeizle.animes.exception.SeasonNotFoundException
import com.range.animeizle.animes.mapper.SeasonMapper
import com.range.animeizle.animes.service.SeasonService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SeasonServiceImpl(val seasonRepository: SeasonRepository,
                        val seasonMapper: SeasonMapper,
                        val animeRepository: AnimeRepository) : SeasonService {

   private val log = LoggerFactory.getLogger(AnimeServiceImpl::class.java)

    override fun findAllAnimeSeasons(animeid: Long): List<SeasonResponse> {

        return   seasonRepository.findSeasonByAnime_Id(animeid).map (seasonMapper::seasonToSeasonResponse )
    }

    override fun findSeason(id: Long): Season {
        return seasonFinder(id)
    }

    override fun removeSeason(id: Long,details: Boolean): SeasonResponse? {

        val season = seasonFinder(id)
        seasonRepository.delete(season)
        log.warn("Removed season $id")
        return  if(details){
            seasonMapper.seasonToSeasonResponse(season)
        }else {
            null
        }

    }
    @Transactional
    override fun add(seasonRequest: SeasonRequest): SeasonResponse {
        val anime = animeFinder(seasonRequest.animeId)
        val season = Season(
            id= 0 ,
            anime = anime,
            seasonSize = seasonRequest.seasonSize,
            seasonNumber = seasonRequest.seasonNumber,
        )
        val seasonSave = seasonRepository.save(season)
        log.info("saving season $season")
        return  seasonMapper.seasonToSeasonResponse(seasonSave)
    }
    @Transactional
    override fun update(
        id: Long,
        seasonRequest: SeasonRequest
    ): SeasonResponse {
        val season = seasonFinder(id)

        val anime =  animeFinder(seasonRequest.animeId)
        seasonMapper.updateFromRequest(season,seasonRequest, anime)
        seasonRepository.save(season)
        log.info("updating season $season")
        return  seasonMapper.seasonToSeasonResponse(season)
    }


    private fun seasonFinder (id: Long): Season {
        return seasonRepository.findById(id)
            .orElseThrow{
                log.warn("Season not found with id $id")
                SeasonNotFoundException("Season Not Found with id $id") }
    }
    private fun animeFinder (id: Long): Anime {
        return animeRepository.findById(id).orElseThrow{
            log.warn("Anime not found with id $id")
            AnimeNotFoundException("Anime not found with id $id")
        }
    }
}
