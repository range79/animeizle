package com.range.rangeWatch.anime.api

import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import com.range.rangeWatch.anime.dto.response.EpisodeVideoResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@RequestMapping("\${api.prefix}/episode-videos")
interface EpisodeVideoQueryApi {



    @GetMapping("/{episodeId}")
    fun getEpisodeVideo(
        @PathVariable episodeId: UUID,
        @RequestParam(required = false) dubbingLanguage: DubbingLanguage,
        @RequestParam(required = false) quality: VideoQuality
    ): EpisodeVideoResponse


}
