package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.AnimeUpdateRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.multipart.MultipartFile
import java.util.*

interface AnimeService {

    fun getAll(pageable: Pageable): Page<Anime>

    fun getById(id: UUID): Anime

    fun searchByTitle(title: String, pageable: Pageable): Page<Anime>

    fun create(anime: Anime, image: MultipartFile?): Anime

    fun update(id: UUID, updated: AnimeUpdateRequest, image: MultipartFile?): Anime

    fun delete(id: UUID)
}
