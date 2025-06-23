package com.range.animeizle.animes.dto.request

import com.range.animeizle.animes.domain.enums.EpisodeStatus

data class EpisodeRequest (

    val episodeNumber: Int,
    val title: String,
    val description: String,
    val link: String,
    var episodeStatus: EpisodeStatus,
    var animeid: Long
)