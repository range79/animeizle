package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.request.AnimeUpdateRequest
import org.springframework.web.multipart.MultipartFile
import java.util.*

interface AnimeService {



    fun create(anime: AnimeCreateRequest, image: MultipartFile?): Anime

    fun update(id: UUID, updated: AnimeUpdateRequest, image: MultipartFile?): Anime

    fun delete(id: UUID)
}
