package com.range.animeizle.animes.service.impl

import com.range.animeizle.animes.domain.model.Anime
import com.range.animeizle.animes.domain.repository.AnimeRepository
import com.range.animeizle.animes.exception.AnimeNotFoundException
import com.range.animeizle.animes.service.AnimeService
import org.springframework.stereotype.Service

@Service
class AnimeServiceImpl(
    private val animeRepository: AnimeRepository
): AnimeService {
    override fun addAnime(anime: Anime): Long {
   TODO()

    }

    override fun removeAnime(id: Long) {
        return animeRepository.deleteById(id)
    }

    override fun updateAnime(id: Long, anime: Anime): Anime {
        val findedanime = animeRepository.findById(id).orElseThrow { AnimeNotFoundException("Could not find anime with id $id") }
        findedanime.title = anime.title.trim()

        findedanime.description = anime.description.trim()
        findedanime.animeStatus =anime.animeStatus
        return animeRepository.save(findedanime)




    }

    override fun findAll(): List<Anime> {
       return animeRepository.findAll()
    }
}