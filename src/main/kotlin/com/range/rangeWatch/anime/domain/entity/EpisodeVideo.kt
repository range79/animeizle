package com.range.rangeWatch.anime.domain.entity

import com.range.rangeWatch.anime.domain.enums.DubbingLanguage
import com.range.rangeWatch.anime.domain.enums.VideoQuality
import jakarta.persistence.*
import java.util.*


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
    var url: String = "",
    @Enumerated(EnumType.STRING)
    var dubbingLanguage: DubbingLanguage = DubbingLanguage.SUB,
)
