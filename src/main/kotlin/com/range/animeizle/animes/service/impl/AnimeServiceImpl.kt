package com.range.animeizle.animes.service.impl

import com.range.animeizle.animes.domain.enums.AnimeStatus
import com.range.animeizle.animes.domain.mapper.AnimeMapper
import com.range.animeizle.animes.domain.model.Anime
import com.range.animeizle.animes.domain.repository.AnimeRepository
import com.range.animeizle.animes.dto.request.AnimeRequest
import com.range.animeizle.animes.dto.response.AnimeResponse
import com.range.animeizle.animes.exception.AnimeNotFoundException
import com.range.animeizle.animes.service.AnimeService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AnimeServiceImpl(
    private val animeRepository: AnimeRepository,
    private val animeMapper: AnimeMapper
): AnimeService {
    @Transactional
    override fun addAnime(animeRequest: AnimeRequest): AnimeResponse {

        val anime = animeMapper.animeRequestToAnime(animeRequest)

        val animeResponse = animeRepository.save(anime)
        return animeMapper.animeToAnimeResponse(animeResponse)

    }
    @Transactional
    override fun removeAnime(id: Long,returnDetails: Boolean): AnimeResponse? {
        val anime = findAnime(id)

        animeRepository.delete(anime)
        if (returnDetails) {
            val animeResponse =animeMapper.animeToAnimeResponse(anime)
            return animeResponse
        }
        return null
    }
    @Transactional
    override fun updateAnime(id: Long, animeRequest: AnimeRequest): AnimeResponse {
        val foundAnime = findAnime(id)

        foundAnime.title = animeRequest.title
        foundAnime.description = animeRequest.description
        foundAnime.animeStatus =animeRequest.animeStatus
        animeRepository.save(foundAnime)
        val animeResponse = animeMapper.animeToAnimeResponse(foundAnime)
        return animeResponse
    }

    override fun findAll(): List<AnimeResponse> {
        return animeRepository.findAll()
            .map(animeMapper::animeToAnimeResponse)
            .toList()
    }

    override fun setAnimeStatus(
        animeId: Long,
        status: AnimeStatus
    ): AnimeResponse {
        val anime = findAnime(animeId)
        anime.animeStatus=status
        animeRepository.save(anime)
        return animeMapper.animeToAnimeResponse(anime)
    }



    private fun findAnime(id: Long): Anime{
        return  animeRepository.findById(id).orElseThrow { AnimeNotFoundException("Could not find anime $id") }
    }


}