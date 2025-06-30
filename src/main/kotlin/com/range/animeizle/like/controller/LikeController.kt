package com.range.animeizle.like.controller

import com.range.animeizle.like.api.LikeApi
import com.range.animeizle.like.dto.LikeResponse
import com.range.animeizle.like.service.LikeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(
    val likeService: LikeService
): LikeApi{
    override fun likeEpisode(episodeId: Long): ResponseEntity<LikeResponse> {
        return ResponseEntity.ok(likeService.likeEpisode(episodeId))
    }

    override fun removeLikeEpisode(
        id: Long,
        details: Boolean
    ): ResponseEntity<LikeResponse?> {
        return ResponseEntity.ok(likeService.removeLikeEpisode(id, details))
    }

    override fun findAllUserLikes(id: Long): ResponseEntity<List<LikeResponse>> {
        return ResponseEntity.ok(likeService.findAllUserLikes())
    }

}