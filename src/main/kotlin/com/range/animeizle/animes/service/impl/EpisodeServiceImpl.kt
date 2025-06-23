package com.range.animeizle.animes.service.impl

import com.range.animeizle.animes.domain.entity.Episode
import com.range.animeizle.animes.domain.enums.EpisodeStatus
import com.range.animeizle.animes.domain.repository.EpisodeRepository
import com.range.animeizle.animes.domain.repository.SeasonRepository
import com.range.animeizle.animes.dto.request.EpisodeRequest
import com.range.animeizle.animes.dto.response.EpisodeResponse
import com.range.animeizle.animes.exception.EpisodeNotFound
import com.range.animeizle.animes.exception.SeasonNotFoundException
import com.range.animeizle.animes.mapper.EpisodeMapper
import com.range.animeizle.animes.service.EpisodeService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class EpisodeServiceImpl(
    private val seasonRepository: SeasonRepository,
    private val episodeRepository: EpisodeRepository,
    private val episodeMapper: EpisodeMapper
) : EpisodeService {
    private val log = LoggerFactory.getLogger(EpisodeServiceImpl::class.java)
    override fun findAllSeasonEpisodes(id: Long): List<EpisodeResponse> {
        log.debug("findAllSeasonEpisodes with id $id")
        return  episodeRepository.findBySeason_Id(id)
            .map ( episodeMapper::episodeToEpisodeResponse)
    }

    override fun setEpisodeStatus(
        id: Long,
        status: EpisodeStatus
    ): EpisodeResponse {
        log.debug("setEpisodeStatus with id $id")
        val episode = findEpisode(id)
        episode.episodeStatus=status
        episodeRepository.save(episode)
        log.debug("setEpisodeStatus with id $id saved to database")
        return episodeMapper.episodeToEpisodeResponse(episode)

    }

    override fun updateEpisode(
        seasonId: Long,
        episodeRequest: EpisodeRequest
    ): EpisodeResponse {
        val episode = findEpisode(seasonId)
        log.debug("updateEpisode with id {}", episode)
        episodeMapper.updateEpisode(episode, episodeRequest)
        episodeRepository.save(episode)
        log.debug("updateEpisode saved to database with  id {}", episode)
        return episodeMapper.episodeToEpisodeResponse(episode)
    }

    override fun deleteEpisode(
        id: Long,
        description: Boolean
    ): EpisodeResponse? {
        val episode = findEpisode(id)
        episodeRepository.delete(episode)
        log.debug("deleteEpisode with id {}", episode)
        return if (description) {
            episodeMapper.episodeToEpisodeResponse(episode)
        }else{
            null
        }
    }

    override fun findAll(): List<EpisodeResponse> {
        log.debug("findAll")
        return episodeRepository.
        findAll()
            .map (episodeMapper::episodeToEpisodeResponse)
    }

    override fun addEpisode(episodeRequest: EpisodeRequest, seasonId: Long): EpisodeResponse {
        val  season =seasonRepository.findById(seasonId).orElseThrow{
            SeasonNotFoundException("Season not found with id $seasonId")
        }
        val episode = episodeMapper.episodeRequestToEpisode(episodeRequest,season)
        log.debug("addEpisode with id {}", episode)
        episodeRepository.save(episode)
        return episodeMapper.episodeToEpisodeResponse(episode)



    }


    private fun findEpisode(id:Long): Episode{
        return episodeRepository.findById(id).orElseThrow{
            EpisodeNotFound("Could not find episode $id")
        }
    }
}
