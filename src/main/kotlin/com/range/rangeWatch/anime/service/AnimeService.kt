package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.entity.Anime
import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.request.AnimeUpdateRequest
import com.range.rangeWatch.anime.dto.response.AnimeResponse
import org.springframework.web.multipart.MultipartFile
import java.util.*

interface AnimeService {



    fun create(anime: AnimeCreateRequest, image: MultipartFile?)

    fun update(id: UUID, updated: AnimeUpdateRequest, image: MultipartFile?)
    fun delete(id: UUID)
}
