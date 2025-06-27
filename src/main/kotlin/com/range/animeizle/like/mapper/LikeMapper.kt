package com.range.animeizle.like.mapper

import com.range.animeizle.animes.domain.entity.Episode
import com.range.animeizle.like.domain.entity.Like
import com.range.animeizle.like.dto.LikeResponse
import com.range.animeizle.user.domain.entity.User
import org.springframework.stereotype.Component

@Component
class LikeMapper {
    fun LikeRequestToLike(user: User,episode: Episode): Like {
        return Like(
            id = null,
            episode = episode,
            user = user,
            )

    }
    fun LikeToLikeResponse(like :Like):LikeResponse {
        return LikeResponse(
            id = like.id,
            episodeId = like.episode.id,
        )
    }
}