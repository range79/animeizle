package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import jakarta.mail.Multipart
import java.util.*

interface EpisodeVideoCommandService {
    fun uploadVideo(episodeId: UUID,multipart: Multipart,dubbingLanguage: DubbingLanguage)
    fun removeVideo(id: UUID)
}