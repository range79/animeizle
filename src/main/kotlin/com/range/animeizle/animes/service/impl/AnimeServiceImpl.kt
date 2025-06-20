package com.range.animeizle.animes.service.impl

import com.range.animeizle.animes.domain.mapper.AnimeMapper
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
    override fun removeAnime(id: Long): AnimeResponse {
        val anime = animeRepository.findById(id).orElseThrow{
            AnimeNotFoundException("Not found anime $id")
        }

        animeRepository.deleteById(id)
        val animeResponse =animeMapper.animeToAnimeResponse(anime)

        return animeResponse;
    }
    @Transactional
    override fun updateAnime(id: Long, animeRequest: AnimeRequest): AnimeResponse {
        val foundAnime = animeRepository.findById(id).orElseThrow { AnimeNotFoundException("Could not find anime with id $id") }

        foundAnime.title = animeRequest.title
        foundAnime.description = animeRequest.description
        foundAnime.animeStatus =animeRequest.animeStatus

        val animeResponse = animeMapper.animeToAnimeResponse(foundAnime)
        return animeResponse
    }

    override fun findAll(): List<AnimeResponse> {
        return animeRepository.findAll()
            .map(animeMapper::animeToAnimeResponse)
            .toList()
    }
}