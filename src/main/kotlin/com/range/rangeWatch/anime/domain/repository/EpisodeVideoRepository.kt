package com.range.rangeWatch.anime.domain.repository

import com.range.rangeWatch.anime.domain.entity.EpisodeVideo
import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface EpisodeVideoRepository : JpaRepository<EpisodeVideo, UUID> {

    fun findByEpisode_IdAndDubbingLanguageAndQuality(
        episodeId: UUID,
        dubbingLanguage: DubbingLanguage,
        quality: VideoQuality
    ): EpisodeVideo?
}