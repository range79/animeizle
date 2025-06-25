package com.range.animeizle.like.controller

import com.range.animeizle.like.api.LikeApi
import com.range.animeizle.like.dto.LikeRequest
import com.range.animeizle.like.dto.LikeResponse
import com.range.animeizle.like.service.LikeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class LikeController(
    val likeService: LikeService
): LikeApi{
    override fun likeEpisode(likeRequest: LikeRequest): ResponseEntity<LikeResponse> {
        return ResponseEntity.ok(likeService.likeEpisode(likeRequest))
    }

    override fun removeLikeEpisode(
        id: Long,
        details: Boolean
    ): ResponseEntity<LikeResponse?> {
        return ResponseEntity.ok(likeService.removeLikeEpisode(id, details))
    }

    override fun findAllUserLikes(id: Long): ResponseEntity<List<LikeResponse>> {
        return ResponseEntity.ok(likeService.findAllUserLikes(id))
    }

}