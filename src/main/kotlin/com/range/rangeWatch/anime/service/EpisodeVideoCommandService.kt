package com.range.rangeWatch.anime.service


import com.range.rangeWatch.anime.dto.request.EpisodeVideoRequest
import org.springframework.web.multipart.MultipartFile
import java.util.*

interface EpisodeVideoCommandService {
    fun uploadVideo(episode: EpisodeVideoRequest, multipart: MultipartFile)
    fun removeVideo(id: UUID)
}