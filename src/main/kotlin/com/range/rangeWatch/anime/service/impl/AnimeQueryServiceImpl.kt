package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.domain.repository.AnimeRepository
import com.range.rangeWatch.anime.exception.AnimeNotFoundException
import com.range.rangeWatch.anime.service.AnimeQueryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID
@Service
class AnimeQueryServiceImpl(
    private val animeRepository: AnimeRepository,
): AnimeQueryService {
    @Transactional(readOnly = true)
    override fun getAll(pageable: Pageable): Page<Anime> =
        animeRepository.findAll(pageable)
    @Transactional(readOnly = true)
    override fun getById(id: UUID): Anime =
        animeRepository.findById(id).orElseThrow {
            AnimeNotFoundException("Anime Not Found")
        }
    @Transactional(readOnly = true)
    override fun searchByTitle(title: String, pageable: Pageable): Page<Anime> =
        animeRepository.findByTitleContainingIgnoreCase(title, pageable)

}