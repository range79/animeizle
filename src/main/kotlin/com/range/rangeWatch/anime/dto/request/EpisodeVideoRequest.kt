package com.range.rangeWatch.anime.dto.request

import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import java.util.UUID

data class EpisodeVideoRequest (
    var episodeId: UUID,
    val quality: VideoQuality,
    val dubbingLanguage: DubbingLanguage,
)