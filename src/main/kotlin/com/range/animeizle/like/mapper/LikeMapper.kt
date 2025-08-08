package com.range.animeizle.like.mapper

import com.range.animeizle.like.domain.entity.EpisodeLike
import com.range.animeizle.like.dto.LikeResponse
import org.springframework.stereotype.Component

@Component
class LikeMapper {
    fun toLike(userid: Long,episodeId: Long): EpisodeLike {
        return EpisodeLike(
            id = null,
            episodeId = episodeId,
            userId = userid,
        )

    }
    fun toLikeResponse(episodeLike :EpisodeLike):LikeResponse {
        return LikeResponse(
            id = episodeLike.id,
            episodeId = episodeLike.episodeId,
        )
    }
}