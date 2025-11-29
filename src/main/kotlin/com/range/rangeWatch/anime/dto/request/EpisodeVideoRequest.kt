package com.range.rangeWatch.anime.dto.request

import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import jakarta.validation.constraints.NotNull

data class EpisodeVideoRequest(
    @field:NotNull
    var episodeId: Long,
    @field:NotNull
    var dubbingLanguage: DubbingLanguage,
    @field:NotNull
    var quality: VideoQuality,
    )