package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.AnimeUpdateRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.multipart.MultipartFile
import java.util.*

interface AnimeService {



    fun create(anime: AnimeCreateRequest, image: MultipartFile?): Anime

    fun update(id: UUID, updated: AnimeUpdateRequest, image: MultipartFile?): Anime

    fun delete(id: UUID)
}
