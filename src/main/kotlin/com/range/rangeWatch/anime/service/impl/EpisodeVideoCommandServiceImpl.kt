package com.range.rangeWatch.anime.service.impl

import com.range.rangeWatch.anime.dto.request.EpisodeVideoRequest
import com.range.rangeWatch.anime.service.EpisodeVideoCommandService
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.UUID
@Service
class EpisodeVideoCommandServiceImpl : EpisodeVideoCommandService {
    override fun uploadVideo(
        episode: EpisodeVideoRequest,
        multipart: MultipartFile
    ) {
        TODO("Not yet implemented")
    }

    override fun removeVideo(id: UUID) {
        TODO("Not yet implemented")
    }
}
