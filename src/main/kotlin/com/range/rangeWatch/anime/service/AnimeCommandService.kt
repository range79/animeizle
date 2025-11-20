package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.dto.request.AnimeCreateRequest
import com.range.rangeWatch.anime.dto.request.AnimeUpdateRequest
import org.springframework.web.multipart.MultipartFile
import java.util.*

interface AnimeCommandService {



    fun create(anime: AnimeCreateRequest, image: MultipartFile?)

    fun update(id: UUID, updated: AnimeUpdateRequest, image: MultipartFile?)
    fun delete(id: UUID)
}
