package com.range.rangeWatch.anime.service

import com.range.rangeWatch.anime.dto.EpisodeRequest

interface EpisodeService {
    fun create(episodeRequest: EpisodeRequest)


}