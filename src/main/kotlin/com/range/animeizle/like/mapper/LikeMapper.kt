package com.range.animeizle.like.mapper

import com.range.animeizle.like.domain.entity.Like
import com.range.animeizle.like.dto.LikeResponse
import org.springframework.stereotype.Component

@Component
class LikeMapper {
    fun toLike(userid: Long,episodeId: Long): Like {
        return Like(
            id = null,
            episodeId = episodeId,
            userId = userid,
        )

    }
    fun toLikeResponse(like :Like):LikeResponse {
        return LikeResponse(
            id = like.id,
            episodeId = like.episodeId,
        )
    }
}