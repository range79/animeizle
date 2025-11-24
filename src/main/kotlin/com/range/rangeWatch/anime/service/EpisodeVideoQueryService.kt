package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.dto.request.EpisodeVideoRequest

interface EpisodeVideoQueryService {
    fun findDubbingLanguageAndVideoQuality(episodeVideoRequest: EpisodeVideoRequest)


}