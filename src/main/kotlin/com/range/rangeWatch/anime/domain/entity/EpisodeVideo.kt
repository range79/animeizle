package com.range.rangeWatch.anime.domain.entity

import com.range.rangeWatch.anime.domain.enums.VideoQuality
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID


@Entity
@Table(name = "episode_video")
data class EpisodeVideo(
    @Id
    var id: UUID = UUID.randomUUID(),
    val episodeNumber: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "episode_id")
    var episode: Episode? = null,

    @Enumerated(EnumType.STRING)
    var quality: VideoQuality = VideoQuality.P1080,

    var url: String = ""
)
