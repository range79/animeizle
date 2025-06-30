package com.range.animeizle.like.service

import com.range.animeizle.like.dto.LikeResponse

interface LikeService {
    fun likeEpisode(episodeId: Long): LikeResponse
    fun removeLikeEpisode(id: Long,details: Boolean): LikeResponse?
    fun findAllUserLikes(): List<LikeResponse>
}