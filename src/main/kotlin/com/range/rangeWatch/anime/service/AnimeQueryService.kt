package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Anime
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface AnimeQueryService {
    fun getAll(pageable: Pageable): Page<Anime>

    fun getById(id: UUID): Anime

    fun searchByTitle(title: String, pageable: Pageable): Page<Anime>


}