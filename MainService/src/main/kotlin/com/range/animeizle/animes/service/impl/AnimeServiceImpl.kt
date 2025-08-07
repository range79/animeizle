package com.range.animeizle.animes.service.impl

import com.range.animeizle.animes.domain.entity.Anime
import com.range.animeizle.animes.domain.enums.AnimeStatus
import com.range.animeizle.animes.domain.repository.AnimeRepository
import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse
import com.range.animeizle.animes.exception.AnimeAlreadyRegistered
import com.range.animeizle.animes.exception.AnimeNotFoundException
import com.range.animeizle.animes.mapper.AnimeMapper
import com.range.animeizle.animes.service.AnimeService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AnimeServiceImpl(
    private val animeRepository: AnimeRepository,
    private val animeMapper: AnimeMapper,

    ): AnimeService {
    private val log = LoggerFactory.getLogger(AnimeServiceImpl::class.java)
    @Transactional
    override fun addAnime(animeRequest: AnimeRequest): AnimeResponse {
        if (animeRepository.existsByTitle(animeRequest.title)){
            log.info("Already registered new anime ${animeRequest.title}")
            throw AnimeAlreadyRegistered("Anime already registered ${animeRequest.title}")
        }

        val anime = animeMapper.animeRequestToAnime(animeRequest)

        val animeResponse = animeRepository.save(anime)
        log.info("Created new anime ${animeRequest.title}")
        return animeMapper.animeToAnimeResponse(animeResponse)

    }
    @Transactional
    override fun removeAnime(id: Long,returnDetails: Boolean): AnimeResponse? {
        val anime = findAnime(id)

        animeRepository.delete(anime)
        log.info("Removed anime ${anime.id}")
        if (returnDetails) {
            val animeResponse =animeMapper.animeToAnimeResponse(anime)
            return animeResponse
        }
        return null
    }
    @Transactional
    override fun updateAnime(id: Long, animeRequest: AnimeRequest): AnimeResponse {
        val foundAnime = findAnime(id)
        animeMapper.updateFromRequest(foundAnime,animeRequest)
        animeRepository.save(foundAnime)

        return animeMapper.animeToAnimeResponse(foundAnime)
    }

    override fun findAll(): List<AnimeResponse> {
        return animeRepository.findAll()
            .map(animeMapper::animeToAnimeResponse)
            .toList()
    }
    @Transactional
    override fun setAnimeStatus(
        animeId: Long,
        status: AnimeStatus
    ): AnimeResponse {
        val anime = findAnime(animeId)
        anime.animeStatus=status
        animeRepository.save(anime)
        log.info("Updated anime status ${anime.id}, to $status")
        return animeMapper.animeToAnimeResponse(anime)
    }

    override fun findAnimeWithId(animeId: Long): Anime {
        return findAnime(animeId)
    }


    private fun findAnime(id: Long): Anime{
        return  animeRepository.findById(id).orElseThrow {
            log.warn("Anime not found with id $id")
            AnimeNotFoundException("Could not find anime $id")
        }
    }


}