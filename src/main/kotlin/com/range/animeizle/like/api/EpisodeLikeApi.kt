package com.range.animeizle.like.api

import com.range.animeizle.like.dto.LikeResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/likes")
interface EpisodeLikeApi{
    @PostMapping("/likeEpisode")
    fun likeEpisode(@RequestBody episodeId: Long): ResponseEntity<LikeResponse>
    @DeleteMapping("/delete/{id}/details")
    fun removeLikeEpisode(@PathVariable id: Long, @RequestParam(defaultValue = "false") details: Boolean): ResponseEntity<LikeResponse?>
    @GetMapping("/episode/{id}")
    fun findAllUserLikes(@PathVariable id: Long): ResponseEntity<List<LikeResponse>>

}